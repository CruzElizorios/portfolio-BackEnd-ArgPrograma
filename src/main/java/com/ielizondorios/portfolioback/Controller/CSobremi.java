
package com.ielizondorios.portfolioback.Controller;

import com.ielizondorios.portfolioback.Dto.DtoSobremi;
import com.ielizondorios.portfolioback.Entity.Sobremi;
import com.ielizondorios.portfolioback.Security.Controller.Mensaje;
import com.ielizondorios.portfolioback.Service.SSobremi;
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
@RequestMapping("/sobremi")
@CrossOrigin(origins = {"https://portfoliofronticruz.web.app","http://localhost:4200"})
public class CSobremi {
    @Autowired
    SSobremi sSobremi;
    
    @GetMapping("/lista")      
    public ResponseEntity<List<Sobremi>> list(){
        List<Sobremi> list = sSobremi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/infoSobremi/{id}")
    public ResponseEntity<Sobremi> getById(@PathVariable("id") int id){
        if (!sSobremi.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        Sobremi sobremi = sSobremi.getOne(id).get();
        return new ResponseEntity(sobremi, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
     //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sSobremi.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID que quiere eliminar"), HttpStatus.NOT_FOUND);
        }
        sSobremi.delete(id);
        return new ResponseEntity(new Mensaje("descripcion sobre mi eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoSobremi dtoSobremi){
        // se fija si esta vacia la descripcion y emite alerta
        if (StringUtils.isBlank(dtoSobremi.getInfo())) {
            return new ResponseEntity(new Mensaje("la descripcion no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
        
        Sobremi sobremi = new Sobremi( dtoSobremi.getInfo());
        sSobremi.save(sobremi);
        
        return new ResponseEntity(new Mensaje("descripcion en Sobre Mi agregada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSobremi dtoSobremi){
        //se fija si existe un id,sino lo encuentra emite una alerta
        if (!sSobremi.existsById(id)) {
            return new ResponseEntity(new Mensaje("el ID en Sobre Mi no existe"), HttpStatus.NOT_FOUND);
        }
        // se fija si esta vacia la descripcion y emite alerta
        if (StringUtils.isBlank(dtoSobremi.getInfo())) {
            return new ResponseEntity(new Mensaje("la descripcion no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }
        //si lo anterior se cumple actualiza el objeto
        Sobremi sobremi = sSobremi.getOne(id).get();
        sobremi.setInfo(dtoSobremi.getInfo());
         //guarda con los cambios
        sSobremi.save(sobremi);
        return new ResponseEntity(new Mensaje("descripcion en Sobre Mi actualizada correctamente"), HttpStatus.OK);
    }
    
}
