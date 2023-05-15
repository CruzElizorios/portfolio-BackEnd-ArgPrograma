
package com.ielizondorios.portfolioback.Dto;

import jakarta.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String duracionE;
    @NotBlank
    private String descripcionE;
    
    //constructor

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String duracionE, String descripcionE) {
        this.nombreE = nombreE;
        this.duracionE = duracionE;
        this.descripcionE = descripcionE;
    }
    
    //getter setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDuracionE() {
        return duracionE;
    }

    public void setDuracionE(String duracionE) {
        this.duracionE = duracionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}
