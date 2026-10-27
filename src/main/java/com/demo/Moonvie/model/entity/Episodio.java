package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "episodio")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEpisodio;
    @Column(nullable = false)
    private int numero;
    @Column(length = 150, nullable = false)
    private String titulo;
    @Column(nullable = true)
    private int duracao;
    private boolean codStatus;

  
    public Long getIdEpisodio() {
        return idEpisodio;
    }
    public void setIdEpisodio(Long idEpisodio) {
        this.idEpisodio = idEpisodio;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
      public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

}
