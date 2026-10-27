package com.demo.Moonvie.model.services;

import com.demo.Moonvie.model.entity.Classifica;
import com.demo.Moonvie.model.repository.ClassificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificaService {

    @Autowired
    private ClassificaRepository classificaRepository;

    public List<Classifica> findAll() {
        return classificaRepository.findAll();
    }

    public Classifica findById(Long id) {
        return classificaRepository.findById(id).orElse(null);
    }

    public Classifica save(Classifica classifica) {
        return classificaRepository.save(classifica);
    }

    public Classifica update(Long id, Classifica classificaAtualizada) {
        Classifica classificaExistente = classificaRepository.findById(id).orElse(null);
        if (classificaExistente != null) {
            classificaExistente.setIdUsuario(classificaAtualizada.getIdUsuario());
            classificaExistente.setIdTitulo(classificaAtualizada.getIdTitulo());
            classificaExistente.setNota(classificaAtualizada.getNota());
            classificaExistente.setComentario(classificaAtualizada.getComentario());
            classificaExistente.setCodStatus(classificaAtualizada.isCodStatus());
            return classificaRepository.save(classificaExistente);
        }
        return null;
    }

    public void delete(Long id) {
        classificaRepository.deleteById(id);
    }
}