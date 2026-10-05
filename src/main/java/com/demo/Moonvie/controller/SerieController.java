package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Serie;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/serie")
public class SerieController {

    List<Serie> series = new ArrayList<Serie>();

    @GetMapping
    public List<Serie> getSeries() {
        Serie s1 = new Serie();
        s1.setIdSerie(1L);
        s1.setElenco("Elenco da Série 1");
        s1.setStatus("Em andamento");

        Serie s2 = new Serie();
        s2.setIdSerie(2L);
        s2.setElenco("Elenco da Série 2");
        s2.setStatus("Finalizada");
        
        Serie s3 = new Serie();
        s3.setIdSerie(3L);
        s3.setElenco("Elenco da Série 3");
        s3.setStatus("Em andamento");

        series.add(s1);
        series.add(s2);
        series.add(s3);
        
        return series;
    }

}
