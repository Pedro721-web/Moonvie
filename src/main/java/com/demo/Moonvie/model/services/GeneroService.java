package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Genero;
import com.demo.Moonvie.model.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero update(Long id, Genero generoAtualizado) {
        Genero generoExistente = generoRepository.findById(id).orElse(null);
        if (generoExistente != null) {
            generoExistente.setNome(generoAtualizado.getNome());
            generoExistente.setDescricao(generoAtualizado.getDescricao());
            generoExistente.setCodStatus(generoAtualizado.isCodStatus());
            return generoRepository.save(generoExistente);
        }
        return null;
    }

    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}