
package com.ielizondorios.portfolioback.Repository;

import com.ielizondorios.portfolioback.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
     public Optional<Proyectos> findByTitulo(String titulo);
     public boolean existsByTitulo(String titulo);
}
