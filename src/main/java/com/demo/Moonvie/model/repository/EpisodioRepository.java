package com.demo.Moonvie.model.repository;

import com.demo.Moonvie.model.entity.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
}