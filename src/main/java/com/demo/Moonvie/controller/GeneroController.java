package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Genero;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/api/v1/genero")
public class GeneroController {

    List<Genero> generos = new ArrayList<Genero>();

    @GetMapping
    public List<Genero> getGeneros() {
        Genero g1 = new Genero();
        g1.setIdGenero(1L);
        g1.setNome("Ação");
        g1.setDescricao("Filmes de ação são caracterizados por cenas emocionantes, perseguições, lutas e explosões, mantendo o público em suspense e entretido.");

        Genero g2 = new Genero();
        g2.setIdGenero(2L);
        g2.setNome("Comédia");
        g2.setDescricao("Filmes de comédia têm como objetivo principal provocar risadas e entretenimento, explorando situações engraçadas, diálogos espirituosos e personagens cômicos.");

        Genero g3 = new Genero();
        g3.setIdGenero(3L);
        g3.setNome("Drama");
        g3.setDescricao("Filmes de drama exploram emoções profundas, conflitos humanos e situações");

        generos.add(g1);
        generos.add(g2);
        generos.add(g3);
        
        return generos;
    }

}
