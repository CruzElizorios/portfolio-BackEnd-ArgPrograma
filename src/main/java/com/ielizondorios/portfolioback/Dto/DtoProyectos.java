package com.ielizondorios.portfolioback.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoProyectos {

    @NotBlank
    private String titulo;
    @NotBlank
    private String tech;
    @NotBlank
    private String descrip;
    @NotBlank
    private String linkgit;
    @NotBlank
    private String linkpreview;
    @NotBlank
    private String img;

//constructor
    public DtoProyectos() {
    }

    public DtoProyectos(String titulo, String tech, String descrip, String linkgit, String linkpreview, String img) {
        this.titulo = titulo;
        this.tech = tech;
        this.descrip = descrip;
        this.linkgit = linkgit;
        this.linkpreview = linkpreview;
        this.img = img;
    }
    
//getter setter
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
