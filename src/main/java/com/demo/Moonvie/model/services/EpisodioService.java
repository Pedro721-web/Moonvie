package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Episodio;
import com.demo.Moonvie.model.repository.EpisodioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioService {

    @Autowired
    private EpisodioRepository episodioRepository;

    public List<Episodio> findAll() {
        return episodioRepository.findAll();
    }

    public Episodio findById(Long id) {
        return episodioRepository.findById(id).orElse(null);
    }

    public Episodio save(Episodio episodio) {
        return episodioRepository.save(episodio);
    }

    public Episodio update(Long id, Episodio episodioAtualizado) {
        Episodio episodioExistente = episodioRepository.findById(id).orElse(null);
        if (episodioExistente != null) {
            episodioExistente.setNumero(episodioAtualizado.getNumero());
            episodioExistente.setTitulo(episodioAtualizado.getTitulo());
            episodioExistente.setDuracao(episodioAtualizado.getDuracao());
            episodioExistente.setCodStatus(episodioAtualizado.isCodStatus());
            return episodioRepository.save(episodioExistente);
        }
        return null;
    }

    public void delete(Long id) {
        episodioRepository.deleteById(id);
    }
}