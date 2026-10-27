package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;
    @Column(length = 255, nullable = true)
    private String elenco;
    @Column(length = 50, nullable = true)
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
