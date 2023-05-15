package com.ielizondorios.portfolioback.Controller;

import com.ielizondorios.portfolioback.Dto.DtoExperiencia;
import com.ielizondorios.portfolioback.Entity.Experiencia;
import com.ielizondorios.portfolioback.Security.Controller.Mensaje;
import com.ielizondorios.portfolioback.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/infoExp/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminado"), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia) {
        //se fija si esta vacio el nombre
        if (StringUtils.isBlank(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //se fija si ya existe una experiencia con ese nombre para que no haya repetido
        if (sExperiencia.existsByNombreE(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        //si todo lo anterior se cumple que no este vacio y que no este repetido crea el objeto experiencia
        Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreE(), dtoExperiencia.getDuracionE(), dtoExperiencia.getDescripcionE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombre de la experiencia que ya estaba con la que se quiere agregar si son iguales tira error
        if (sExperiencia.existsByNombreE(dtoExperiencia.getNombreE()) && sExperiencia.getByNombreE(dtoExperiencia.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("ese nombre de experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        // se fija si esta vacio el nombre y emite alerta
        if (StringUtils.isBlank(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("el nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        //si lo anterior se cumple actualiza el objeto
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoExperiencia.getNombreE());
        experiencia.setDuracionE(dtoExperiencia.getDuracionE());
        experiencia.setDescripcionE(dtoExperiencia.getDescripcionE());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
    }

}
