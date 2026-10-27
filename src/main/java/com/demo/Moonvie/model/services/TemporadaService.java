package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Temporada;
import com.demo.Moonvie.model.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaService {

    @Autowired
    private TemporadaRepository temporadaRepository;

    public List<Temporada> findAll() {
        return temporadaRepository.findAll();
    }

    public Temporada findById(Long id) {
        return temporadaRepository.findById(id).orElse(null);
    }

    public Temporada save(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }

    public Temporada update(Long id, Temporada temporadaAtualizada) {
        Temporada temporadaExistente = temporadaRepository.findById(id).orElse(null);
        if (temporadaExistente != null) {
            temporadaExistente.setNumero(temporadaAtualizada.getNumero());
            temporadaExistente.setCodStatus(temporadaAtualizada.isCodStatus());
            return temporadaRepository.save(temporadaExistente);
        }
        return null;
    }

    public void delete(Long id) {
        temporadaRepository.deleteById(id);
    }
}
