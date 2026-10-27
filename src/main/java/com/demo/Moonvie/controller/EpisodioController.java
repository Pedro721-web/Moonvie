package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Episodio;
import com.demo.Moonvie.model.repository.EpisodioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/episodios")
public class EpisodioController {

    @Autowired
    private EpisodioRepository episodioRepository;

    @GetMapping
    public ResponseEntity<List<Episodio>> findAll() {
        return ResponseEntity.ok(episodioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Episodio episodio = episodioRepository.findById(id).orElse(null);
        if (episodio != null) {
            return ResponseEntity.ok(episodio);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Episodio> save(@RequestBody Episodio episodio) {
        Episodio novoEpisodio = episodioRepository.save(episodio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEpisodio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Episodio atualizado) {
        Episodio existente = episodioRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNumero(atualizado.getNumero());
            existente.setTitulo(atualizado.getTitulo());
            existente.setDuracao(atualizado.getDuracao());
            existente.setCodStatus(atualizado.isCodStatus());
            return ResponseEntity.ok(episodioRepository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Episodio episodio = episodioRepository.findById(id).orElse(null);
        if (episodio != null) {
            episodioRepository.delete(episodio);
            return ResponseEntity.ok("Episódio excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado para exclusão.");
    }
}