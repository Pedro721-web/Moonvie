package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

public class Genero {

    private Long idGenero;
    private String nome;
    private String descricao;
    private boolean codStatus;
 
    public Long getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
      public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

}
