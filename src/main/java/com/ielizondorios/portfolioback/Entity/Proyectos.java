
package com.ielizondorios.portfolioback.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String tech;
    
    @NotNull
    private String descrip;
    
    @NotNull
    private String linkgit;
    
    @NotNull
    private String linkpreview;
    
    @NotNull
    private String img;
//constructores
    public Proyectos() {
    }

    public Proyectos(String titulo, String tech, String descrip, String linkgit, String linkpreview, String img) {
        this.titulo = titulo;
        this.tech = tech;
        this.descrip = descrip;
        this.linkgit = linkgit;
        this.linkpreview = linkpreview;
        this.img = img;
    }
//getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getLinkgit() {
        return linkgit;
    }

    public void setLinkgit(String linkgit) {
        this.linkgit = linkgit;
    }

    public String getLinkpreview() {
        return linkpreview;
    }

    public void setLinkpreview(String linkpreview) {
        this.linkpreview = linkpreview;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
