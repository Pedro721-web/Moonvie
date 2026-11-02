package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Serie;
import com.demo.Moonvie.model.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public ResponseEntity<List<Serie>> findAll() {
        return ResponseEntity.ok(serieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Serie serie = serieService.findById(id);
        if (serie != null) {
            return ResponseEntity.ok(serie);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        Serie novaSerie = serieService.save(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Serie atualizada) {
        Serie serieAtualizada = serieService.update(id, atualizada);
        if (serieAtualizada != null) {
            return ResponseEntity.ok(serieAtualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Serie serie = serieService.findById(id);
        if (serie != null) {
            serieService.delete(id);
            return ResponseEntity.ok("Série excluída com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada para exclusão.");
    }
}