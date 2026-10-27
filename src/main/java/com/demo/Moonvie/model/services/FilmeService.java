package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Filme;
import com.demo.Moonvie.model.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Filme findById(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme update(Long id, Filme filmeAtualizado) {
        Filme filmeExistente = filmeRepository.findById(id).orElse(null);
        if (filmeExistente != null) {
            filmeExistente.setTitulo(filmeAtualizado.getTitulo());
            filmeExistente.setDuracao(filmeAtualizado.getDuracao());
            filmeExistente.setDiretor(filmeAtualizado.getDiretor());
            filmeExistente.setCodStatus(filmeAtualizado.isCodStatus());
            return filmeRepository.save(filmeExistente);
        }
        return null;
    }

    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }
}