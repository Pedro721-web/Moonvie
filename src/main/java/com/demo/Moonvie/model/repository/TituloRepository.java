package com.demo.Moonvie.model.repository;

import com.demo.Moonvie.model.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {
}