package com.ielizondorios.portfolioback.Dto;

import jakarta.validation.constraints.NotBlank;


public class DtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String duracionEd;
    @NotBlank
    private String descripcionEd;
    
//constructor
    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEd, String duracionEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.duracionEd = duracionEd;
        this.descripcionEd = descripcionEd;
    }

//getter setter
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
