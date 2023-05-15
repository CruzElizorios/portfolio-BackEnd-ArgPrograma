
package com.ielizondorios.portfolioback.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Educacion {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String duracionEd;
    private String descripcionEd;
    
      //constructor

    public Educacion() {
    }

    public Educacion(String nombreEd, String duracionEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.duracionEd = duracionEd;
        this.descripcionEd = descripcionEd;
    }
    
     //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDuracionEd() {
        return duracionEd;
    }

    public void setDuracionEd(String duracionEd) {
        this.duracionEd = duracionEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
    
}
