package com.ielizondorios.portfolioback.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple las condiciones")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple las condiciones")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple las condiciones")
    private String subtitulo;
    
    private String img; 

    public Persona() {
    }

    public Persona(String nombre, String apellido, String subtitulo, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.subtitulo = subtitulo;
        this.img = img;
    }
    
    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
