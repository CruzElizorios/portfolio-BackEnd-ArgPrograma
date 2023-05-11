
package com.ielizondorios.portfolioback.Security.Controller;


public class Mensaje {
    private String mensaje;
    //contructor
    public Mensaje(){
        
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //getter setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }  
}
