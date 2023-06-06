package com.ielizondorios.portfolioback.Controller;

import com.ielizondorios.portfolioback.Dto.DtoProyectos;
import com.ielizondorios.portfolioback.Entity.Proyectos;
import com.ielizondorios.portfolioback.Security.Controller.Mensaje;
import com.ielizondorios.portfolioback.Service.SProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"https://portfoliofronticruz.web.app", "http://localhost:4200"})
public class CProyectos {

    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/infoProyectos/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no se encuentra el ID"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encuentra el ID"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        //se fija si esta vacio el nombre
        if (StringUtils.isBlank(dtoProyectos.getTitulo())) {
            return new ResponseEntity(new Mensaje("El titulo del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //se fija si ya existe un proyecto con ese titulo para que no haya repetido
        if (sProyectos.existsByTitulo(dtoProyectos.getTitulo())) {
            return new ResponseEntity(new Mensaje("Ese titulo de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //si todo lo anterior se cumple, que no este vacio y que no este repetido crea el objeto proyectos
        Proyectos proyectos = new Proyectos(dtoProyectos.getTitulo(), dtoProyectos.getTech(), dtoProyectos.getDescrip(), dtoProyectos.getLinkgit(), dtoProyectos.getLinkpreview(), dtoProyectos.getImg());
        sProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("proyecto agregado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos) {
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.NOT_FOUND);
        }
        //compara el titulo del proyecto que ya estaba con la que se quiere agregar si son iguales tira error
        if (sProyectos.existsByTitulo(dtoProyectos.getTitulo()) && sProyectos.getByTitulo(dtoProyectos.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        // se fija si esta vacio el titulo y emite alerta
        if (StringUtils.isBlank(dtoProyectos.getTitulo())) {
            return new ResponseEntity(new Mensaje("el titulo del proyecto no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        //si lo anterior se cumple actualiza el objeto
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setTitulo(dtoProyectos.getTitulo());
        proyectos.setTech(dtoProyectos.getTech());
        proyectos.setDescrip(dtoProyectos.getDescrip());
        proyectos.setLinkgit(dtoProyectos.getLinkgit());
        proyectos.setLinkpreview(dtoProyectos.getLinkpreview());
        proyectos.setImg(dtoProyectos.getImg());
        //guarda con los cambios
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }
}
