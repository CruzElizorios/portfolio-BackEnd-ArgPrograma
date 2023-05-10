
package com.ielizondorios.portfolioback.Interface;

import com.ielizondorios.portfolioback.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //eliminar un objeto por id
    public void deletePersona(Long id);
    
    //buscar una persona por id
    public Persona findPersona(Long id);
}
