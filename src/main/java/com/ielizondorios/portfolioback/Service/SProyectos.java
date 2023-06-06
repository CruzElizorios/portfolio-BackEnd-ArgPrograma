package com.ielizondorios.portfolioback.Service;

import com.ielizondorios.portfolioback.Entity.Proyectos;
import com.ielizondorios.portfolioback.Repository.RProyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> List() {
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByTitulo(String titulo) {
        return rProyectos.findByTitulo(titulo);
    }

    public void save(Proyectos proyectos) {
        rProyectos.save(proyectos);
    }

    public void delete(int id) {
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyectos.existsById(id);
    }

    public boolean existsByTitulo(String titulo) {
        return rProyectos.existsByTitulo(titulo);
    }
}
