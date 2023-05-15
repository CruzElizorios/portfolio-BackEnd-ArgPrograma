package com.ielizondorios.portfolioback.Controller;

import com.ielizondorios.portfolioback.Dto.DtoEducacion;
import com.ielizondorios.portfolioback.Entity.Educacion;
import com.ielizondorios.portfolioback.Security.Controller.Mensaje;
import com.ielizondorios.portfolioback.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
       @Autowired
        SEducacion sEducacion;
       
        @GetMapping("/lista")
         public ResponseEntity<List<Educacion>> list() {
            List<Educacion> list = sEducacion.List();
            return new ResponseEntity(list, HttpStatus.OK);
         }
         //traer una sola educacion
          @GetMapping("/infoEdu/{id}")
          public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
            if(!sEducacion.existsById(id)){
                return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
            }
            Educacion educacion = sEducacion.getOne(id).get();
            return new ResponseEntity(educacion, HttpStatus.OK);
          }

            @DeleteMapping("/eliminar/{id}")
            public ResponseEntity<?> delete(@PathVariable("id") int id) {
                //se fija si existe un id,sino lo encuentra emite una alerta
                if (!sEducacion.existsById(id)){
                    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
                }
                sEducacion.delete(id);
                return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
            }
            
            @PostMapping("/crear")
            public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion){
                //se fija si esta vacio el nombre
                if (StringUtils.isBlank( dtoEducacion.getNombreEd())) {
                    return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
                }
                //se fija si ya existe una educacion con ese nombre para que no haya repetido
                if(sEducacion.existsByNombreEd(dtoEducacion.getNombreEd())){
                    return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
                }
                //si todo lo anterior se cumple que no este vacio y que no este repetido crea el objeto educacion
                Educacion educacion = new Educacion(dtoEducacion.getNombreEd(), dtoEducacion.getDuracionEd(), dtoEducacion.getDescripcionEd());
                sEducacion.save(educacion);
                
                return new ResponseEntity(new Mensaje("educacion agregada correctamente"), HttpStatus.OK);    
            }
            
            @PutMapping("/actualizar/{id}")
            public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
                //se fija si existe un id,sino lo encuentra emite una alerta
                if (!sEducacion.existsById(id)) {
                    return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
                }
                //compara nombre de la experiencia que ya estaba con la que se quiere agregar si son iguales tira error
                if(sEducacion.existsByNombreEd(dtoEducacion.getNombreEd()) && sEducacion.getByNombreEd(dtoEducacion.getNombreEd()).get().getId() != id){
                    return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
                }
                // se fija si esta vacio el nombre y emite alerta
                if (StringUtils.isBlank(dtoEducacion.getNombreEd())) {
                    return new ResponseEntity(new Mensaje("el nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
                }
                 //si lo anterior se cumple actualiza el objeto
                Educacion educacion = sEducacion.getOne(id).get();
                educacion.setNombreEd(dtoEducacion.getNombreEd());
                educacion.setDuracionEd(dtoEducacion.getDuracionEd());
                educacion.setDescripcionEd(dtoEducacion.getDescripcionEd());
                //guarda con los cambios
                sEducacion.save(educacion);
                return new ResponseEntity(new Mensaje("Educacion actualizada correctamente"), HttpStatus.OK);
            }
}
