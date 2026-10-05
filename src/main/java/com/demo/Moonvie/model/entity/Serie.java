package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

public class Serie {

    private Long idSerie;
    private String elenco;
    private String status;
    private boolean codStatus;
 
    public Long getIdSerie() {
        return idSerie;
    }
    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }
    public String getElenco() {
        return elenco;
    }
    public void setElenco(String elenco) {
        this.elenco = elenco;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
      public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

}
