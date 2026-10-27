package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Serie;
import com.demo.Moonvie.model.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Serie findById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie update(Long id, Serie serieAtualizada) {
        Serie serieExistente = serieRepository.findById(id).orElse(null);
        if (serieExistente != null) {
            serieExistente.setElenco(serieAtualizada.getElenco());
            serieExistente.setStatus(serieAtualizada.getStatus());
            serieExistente.setCodStatus(serieAtualizada.isCodStatus());
            return serieRepository.save(serieExistente);
        }
        return null;
    }

    public void delete(Long id) {
        serieRepository.deleteById(id);
    }
}