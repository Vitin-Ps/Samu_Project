package com.example.SAMU_API.repository;

import com.example.SAMU_API.domain.intercessor.indisponibilidade.IntercessorIndisponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IntercessorIndisponibilidadeRepository extends JpaRepository<IntercessorIndisponibilidade, Long> {
    List<IntercessorIndisponibilidade> findAllByIntercessorId(Long id);

    boolean existsByIntercessorIdAndDia(Long idIntercessor, LocalDateTime diaEscala);
}
