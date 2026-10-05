package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Filme;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/filme")
public class FilmeController {

    List<Filme> filmes = new ArrayList<Filme>();

    @GetMapping
    public List<Filme> getFilmes() {
        Filme f1 = new Filme();
        f1.setIdFilme(1L);
        f1.setTitulo("Inception");
        f1.setDuracao(148);
        f1.setDiretor("Christopher Nolan");

        Filme f2 = new Filme();
        f2.setIdFilme(2L);
        f2.setTitulo("The Matrix");
        f2.setDuracao(136);
        f2.setDiretor("Lana Wachowski, Lilly Wachowski");

        Filme f3 = new Filme();
        f3.setIdFilme(3L);
        f3.setTitulo("The Godfather");
        f3.setDuracao(175);
        f3.setDiretor("Francis Ford Coppola");

        filmes.add(f1);
        filmes.add(f2);
        filmes.add(f3);
        return filmes;
    }
}
