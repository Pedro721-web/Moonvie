package com.demo.Moonvie.model.entity;

public class Filme {

    private Long idFilme;
    private String titulo;
    private int duracao;
    private String diretor;
    
    public Long getIdFilme() {
        return idFilme;
    }
    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
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
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    

}
