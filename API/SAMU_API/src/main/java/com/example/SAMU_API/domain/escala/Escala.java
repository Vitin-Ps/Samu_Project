package com.example.SAMU_API.domain.escala;

import com.example.SAMU_API.domain.escala.configuracao.EscalaConfiguracao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "escala")
@Entity(name = "Escala")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_configuracao")
    private EscalaConfiguracao escalaConfiguracao;
    private String nome;
    private Integer numero_intercessores;
    private LocalDateTime dia;
}
