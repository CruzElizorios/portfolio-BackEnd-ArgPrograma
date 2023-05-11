
package com.ielizondorios.portfolioback.Security.Repository;

import com.ielizondorios.portfolioback.Security.Entity.Rol;
import com.ielizondorios.portfolioback.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
