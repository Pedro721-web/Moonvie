package com.demo.Moonvie.model.entity;

public class Episodio {

    private Long idEpisodio;
    private int numero;
    private String titulo;
    private int duracao;
  
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
    
    

}
