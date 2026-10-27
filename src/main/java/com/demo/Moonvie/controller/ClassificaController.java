package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Classifica;
import com.demo.Moonvie.model.repository.ClassificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classificacoes")
public class ClassificaController {

    @Autowired
    private ClassificaRepository classificaRepository;

    @GetMapping
    public ResponseEntity<List<Classifica>> findAll() {
        return ResponseEntity.ok(classificaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Classifica classifica = classificaRepository.findById(id).orElse(null);
        if (classifica != null) {
            return ResponseEntity.ok(classifica);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classificação não encontrada com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Classifica> save(@RequestBody Classifica classifica) {
        Classifica novaClassifica = classificaRepository.save(classifica);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaClassifica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Classifica atualizada) {
        Classifica existente = classificaRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdUsuario(atualizada.getIdUsuario());
            existente.setIdTitulo(atualizada.getIdTitulo());
            existente.setNota(atualizada.getNota());
            existente.setComentario(atualizada.getComentario());
            existente.setCodStatus(atualizada.isCodStatus());
            return ResponseEntity.ok(classificaRepository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classificação não encontrada para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Classifica classifica = classificaRepository.findById(id).orElse(null);
        if (classifica != null) {
            classificaRepository.delete(classifica);
            return ResponseEntity.ok("Classificação excluída com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classificação não encontrada para exclusão.");
    }
}