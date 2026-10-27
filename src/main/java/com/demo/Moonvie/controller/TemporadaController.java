package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Temporada;
import com.demo.Moonvie.model.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaRepository temporadaRepository;

    @GetMapping
    public ResponseEntity<List<Temporada>> findAll() {
        return ResponseEntity.ok(temporadaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Temporada temporada = temporadaRepository.findById(id).orElse(null);
        if (temporada != null) {
            return ResponseEntity.ok(temporada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Temporada não encontrada com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Temporada> save(@RequestBody Temporada temporada) {
        Temporada novaTemporada = temporadaRepository.save(temporada);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTemporada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Temporada atualizada) {
        Temporada existente = temporadaRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNumero(atualizada.getNumero());
            existente.setCodStatus(atualizada.isCodStatus());
            return ResponseEntity.ok(temporadaRepository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Temporada não encontrada para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Temporada temporada = temporadaRepository.findById(id).orElse(null);
        if (temporada != null) {
            temporadaRepository.delete(temporada);
            return ResponseEntity.ok("Temporada excluída com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Temporada não encontrada para exclusão.");
    }
}