package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;
    @Column(length = 150, nullable = false)
    private String titulo;
    @Column(nullable = true)
    private int duracao;
    @Column(length = 100, nullable = true)
    private String diretor;
    private boolean codStatus;
    
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

      public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

}
