package com.example.SAMU_API.domain.escala.configuracao;

import com.example.SAMU_API.domain.escala.configuracao.EscalaConfiguracao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "escala_configuracao")
@Entity(name = "EscalaConfiguracao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EscalaConfiguracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer max_participacoes;
    private Integer percentual_principal;
}