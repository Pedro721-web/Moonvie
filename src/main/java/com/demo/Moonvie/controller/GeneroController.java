package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Genero;
import com.demo.Moonvie.model.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public ResponseEntity<List<Genero>> findAll() {
        return ResponseEntity.ok(generoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()) {
            return ResponseEntity.ok(genero.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gênero não encontrado com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Genero> save(@RequestBody Genero genero) {
        Genero novoGenero = generoRepository.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoGenero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Genero generoAtualizado) {
        Optional<Genero> generoExistente = generoRepository.findById(id);
        if (generoExistente.isPresent()) {
            Genero genero = generoExistente.get();
            genero.setNome(generoAtualizado.getNome());
            genero.setDescricao(generoAtualizado.getDescricao());
            genero.setCodStatus(generoAtualizado.isCodStatus());
            return ResponseEntity.ok(generoRepository.save(genero));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gênero não encontrado para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()) {
            generoRepository.delete(genero.get());
            return ResponseEntity.ok("Gênero excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gênero não encontrado para exclusão.");
    }
}