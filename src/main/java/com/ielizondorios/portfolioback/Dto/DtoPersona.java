
package com.ielizondorios.portfolioback.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoPersona {
       
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String subtitulo;
    @NotBlank    
    private String img; 
    
//constructor
    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String subtitulo, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.subtitulo = subtitulo;
        this.img = img;
    }
   
    //getter setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
