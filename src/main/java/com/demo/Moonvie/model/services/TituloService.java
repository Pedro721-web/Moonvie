package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Titulo;
import com.demo.Moonvie.model.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloService {

    @Autowired
    private TituloRepository tituloRepository;

    public List<Titulo> findAll() {
        return tituloRepository.findAll();
    }

    public Titulo findById(Long id) {
        return tituloRepository.findById(id).orElse(null);
    }

    public Titulo save(Titulo titulo) {
        return tituloRepository.save(titulo);
    }

    public Titulo update(Long id, Titulo tituloAtualizado) {
        Titulo tituloExistente = tituloRepository.findById(id).orElse(null);
        if (tituloExistente != null) {
            tituloExistente.setNome(tituloAtualizado.getNome());
            tituloExistente.setSinopse(tituloAtualizado.getSinopse());
            tituloExistente.setDescricao(tituloAtualizado.getDescricao());
            tituloExistente.setAnoLancamento(tituloAtualizado.getAnoLancamento());
            tituloExistente.setCodStatus(tituloAtualizado.isCodStatus());
            return tituloRepository.save(tituloExistente);
        }
        return null;
    }

    public void delete(Long id) {
        tituloRepository.deleteById(id);
    }
}