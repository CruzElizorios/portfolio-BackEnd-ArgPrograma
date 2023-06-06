
package com.ielizondorios.portfolioback.Controller;

import com.ielizondorios.portfolioback.Dto.DtoPersona;
import com.ielizondorios.portfolioback.Entity.Persona;
import com.ielizondorios.portfolioback.Security.Controller.Mensaje;
import com.ielizondorios.portfolioback.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin (origins = {"https://portfoliofronticruz.web.app","http://localhost:4200"})
        
public class PersonaController {
    @Autowired 
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
        //se fija si esta vacio el nombre
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //se fija si ya existe una experiencia con ese nombre para que no haya repetido
        if (sPersona.existsByNombre(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        //si todo lo anterior se cumple que no este vacio y que no este repetido crea el objeto experiencia
        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getApellido(), dtoPersona.getSubtitulo(),dtoPersona.getImg());
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("La persona fue creada correctamente"), HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}") 
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
        }
        //compara nombre de la persona que ya estaba con la que se quiere agregar si son iguales tira error
        if (sPersona.existsByNombre(dtoPersona.getNombre()) && sPersona.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("ese nombre de persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        // se fija si esta vacio el nombre y emite alerta
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("el nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        //si lo anterior se cumple actualiza el objeto
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setSubtitulo(dtoPersona.getSubtitulo());
        persona.setImg(dtoPersona.getImg());

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("La persona fue actualizada correctamente"), HttpStatus.OK);
    }
    
}
