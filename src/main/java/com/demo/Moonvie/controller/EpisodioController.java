package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Episodio;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/episodio")
public class EpisodioController {

    List<Episodio> episodios = new ArrayList<Episodio>();

    @GetMapping
    public List<Episodio> getEpisodios() {
        Episodio e1 = new Episodio();
        e1.setIdEpisodio(1L);
        e1.setTitulo("Pilot");
        e1.setDuracao(42);
        e1.setNumero(1);

        Episodio e2 = new Episodio();
        e2.setIdEpisodio(2L);
        e2.setTitulo("The One Where It All Began");
        e2.setDuracao(45);
        e2.setNumero(2);

        Episodio e3 = new Episodio();
        e3.setIdEpisodio(3L);
        e3.setTitulo("The One with the Blackout");
        e3.setDuracao(44);
        e3.setNumero(3);

        episodios.add(e1);
        episodios.add(e2);
        episodios.add(e3);
        
        return episodios;
    }

}
