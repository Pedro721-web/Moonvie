package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Titulo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/api/v1/titulo")
public class TituloController {

    List<Titulo> titulos = new ArrayList<Titulo>();

    @GetMapping 
    public List<Titulo> getTitulos() {
        Titulo t1 = new Titulo();
        t1.setIdTitulo(1L);
        t1.setTitulo("The Witcher");
        t1.setTituloOriginal(null);
        t1.setSinopse("Geralt de Rívia, um caçador de monstros solitário, luta para encontrar seu lugar em um mundo onde as pessoas muitas vezes se mostram mais perversas do que as bestas.");
        t1.setAno(2019);
        t1.setClassificacao("16");
        t1.setCapa("https://br.web.img3.acsta.net/pictures/19/12/17/15/51/4512950.jpg");
        t1.setTrailer("https://www.youtube.com/watch?v=ndl1W4ltcmg");

        Titulo t2 = new Titulo();
        t2.setIdTitulo(2L);
        t2.setTitulo("Breaking Bad");
        t2.setTituloOriginal(null);
        t2.setSinopse("Um professor de química do ensino médio diagnosticado com câncer de pulmão inoperável se volta para a fabricação e venda de metanfetamina para garantir o futuro financeiro de sua família.");
        t2.setAno(2008);
        t2.setClassificacao("18");
        t2.setCapa("https://br.web.img3.acsta.net/pictures/19/12/17/15/51/4512950.jpg");
        t2.setTrailer("https://www.youtube.com/watch?v=ndl1W4ltcmg");

        titulos.add(t1);
        titulos.add(t2);

        return titulos;
    }
}
