package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Episodio;
import com.demo.Moonvie.model.services.EpisodioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/episodios")
public class EpisodioController {

    @Autowired
    private EpisodioService episodioService; // ✅ Injetando o Service em vez do Repository diretamente

    @GetMapping
    public ResponseEntity<List<Episodio>> findAll() {
        return ResponseEntity.ok(episodioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Episodio episodio = episodioService.findById(id);
        if (episodio != null) {
            return ResponseEntity.ok(episodio);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Episodio> save(@RequestBody Episodio episodio) {
        Episodio novoEpisodio = episodioService.save(episodio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEpisodio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Episodio atualizado) {
        Episodio episodioAtualizado = episodioService.update(id, atualizado);
        if (episodioAtualizado != null) {
            return ResponseEntity.ok(episodioAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Episodio episodio = episodioService.findById(id);
        if (episodio != null) {
            episodioService.delete(id);
            return ResponseEntity.ok("Episódio excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Episódio não encontrado para exclusão.");
    }
}