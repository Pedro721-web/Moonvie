package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Filme;
import com.demo.Moonvie.model.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public ResponseEntity<List<Filme>> findAll() {
        return ResponseEntity.ok(filmeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id).orElse(null);
        if (filme != null) {
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody Filme filme) {
        Filme novoFilme = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFilme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Filme atualizado) {
        Filme existente = filmeRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTitulo(atualizado.getTitulo());
            existente.setDuracao(atualizado.getDuracao());
            existente.setDiretor(atualizado.getDiretor());
            existente.setCodStatus(atualizado.isCodStatus());
            return ResponseEntity.ok(filmeRepository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id).orElse(null);
        if (filme != null) {
            filmeRepository.delete(filme);
            return ResponseEntity.ok("Filme excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado para exclusão.");
    }
}