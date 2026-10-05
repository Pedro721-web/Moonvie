package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Temporada;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/temporada")
public class TemporadaController {

    List<Temporada> temporadas = new ArrayList<Temporada>();

    @GetMapping
    public List<Temporada> getTemporadas() {
        Temporada t1 = new Temporada();
        t1.setIdTemporada(1L);
        t1.setNumero(1);

        Temporada t2 = new Temporada();
        t2.setIdTemporada(2L);
        t2.setNumero(2);

        Temporada t3 = new Temporada();
        t3.setIdTemporada(3L);
        t3.setNumero(3);

        temporadas.add(t1);
        temporadas.add(t2);
        temporadas.add(t3);
        
        return temporadas;
    }

}
