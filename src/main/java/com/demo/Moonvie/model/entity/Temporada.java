package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTemporada;
    @Column(nullable = false)
    private int numero;
    private boolean codStatus;
  
    public Long getIdTemporada() {
        return idTemporada;
    }
    public void setIdTemporada(Long idTemporada) {
        this.idTemporada = idTemporada;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

      public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }
}
