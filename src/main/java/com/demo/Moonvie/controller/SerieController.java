package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Serie;
import com.demo.Moonvie.model.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public ResponseEntity<List<Serie>> findAll() {
        return ResponseEntity.ok(serieRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Serie serie = serieRepository.findById(id).orElse(null);
        if (serie != null) {
            return ResponseEntity.ok(serie);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        Serie novaSerie = serieRepository.save(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Serie atualizada) {
        Serie existente = serieRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setElenco(atualizada.getElenco());
            existente.setStatus(atualizada.getStatus());
            existente.setCodStatus(atualizada.isCodStatus());
            return ResponseEntity.ok(serieRepository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Serie serie = serieRepository.findById(id).orElse(null);
        if (serie != null) {
            serieRepository.delete(serie);
            return ResponseEntity.ok("Série excluída com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada para exclusão.");
    }
}