package com.example.SAMU_API.repository;

import com.example.SAMU_API.domain.escala.Escala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findAllByEscalaConfiguracaoId(Long id);
}
