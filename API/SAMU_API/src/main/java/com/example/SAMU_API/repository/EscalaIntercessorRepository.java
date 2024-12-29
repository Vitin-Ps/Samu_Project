package com.example.SAMU_API.repository;

import com.example.SAMU_API.domain.escala.intercessor.EscalaIntercessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EscalaIntercessorRepository extends JpaRepository<EscalaIntercessor, Long> {
    List<EscalaIntercessor> findAllByEscalaConfiguracaoId(Long idConfiguracao);

    List<EscalaIntercessor> findAllByEscalaId(Long id);

    @Query(nativeQuery = true, value = """
        SELECT COUNT(*) FROM escala_intercessor
        WHERE id_escala = :idEscala AND tipo_intercessor = :tipoIntercessor
    """)
    long countEscala(@Param("idEscala") Long idEscala, @Param("tipoIntercessor") String tipoIntercessor);


    void deleteAllByEscalaConfiguracaoId(Long id);

    boolean existsByEscalaIdAndIntercessorIdAndEscalaConfiguracaoId(Long idEscala, Long idIntercessor, Long idConfiguracao);
}
