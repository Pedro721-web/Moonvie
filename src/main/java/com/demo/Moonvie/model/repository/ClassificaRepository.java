package com.demo.Moonvie.model.repository;

import com.demo.Moonvie.model.entity.Classifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificaRepository extends JpaRepository<Classifica, Long> {
}