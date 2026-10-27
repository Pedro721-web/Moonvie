package com.demo.Moonvie.controller;

import com.demo.Moonvie.model.entity.Titulo;
import com.demo.Moonvie.model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/titulos")
public class TituloController {

    @Autowired
    private TituloRepository tituloRepository;

    @GetMapping
    public ResponseEntity<List<Titulo>> findAll() {
        return ResponseEntity.ok(tituloRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Titulo> titulo = tituloRepository.findById(id);
        if (titulo.isPresent()) {
            return ResponseEntity.ok(titulo.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado com o ID: " + id);
    }

    @PostMapping
    public ResponseEntity<Titulo> save(@RequestBody Titulo titulo) {
        Titulo novoTitulo = tituloRepository.save(titulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTitulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Titulo tituloAtualizado) {
        Optional<Titulo> tituloExistente = tituloRepository.findById(id);
        if (tituloExistente.isPresent()) {
            Titulo titulo = tituloExistente.get();
            titulo.setNome(tituloAtualizado.getNome());
            titulo.setSinopse(tituloAtualizado.getSinopse());
            titulo.setDescricao(tituloAtualizado.getDescricao());
            titulo.setAnoLancamento(tituloAtualizado.getAnoLancamento());
            titulo.setCodStatus(tituloAtualizado.isCodStatus());
            return ResponseEntity.ok(tituloRepository.save(titulo));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado para atualização.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Titulo> titulo = tituloRepository.findById(id);
        if (titulo.isPresent()) {
            tituloRepository.delete(titulo.get());
            return ResponseEntity.ok("Título excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Título não encontrado para exclusão.");
    }
}