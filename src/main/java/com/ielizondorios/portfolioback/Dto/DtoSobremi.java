
package com.ielizondorios.portfolioback.Dto;

import jakarta.validation.constraints.NotBlank;


public class DtoSobremi {
    @NotBlank
    private String info;

    public DtoSobremi() {
    }
  
    public DtoSobremi(String info) {
        this.info = info;
    }
      
    //getter setter

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
            
        
}
