package com.example.SAMU_API.domain.escala.personalizada.dias;

import com.example.SAMU_API.domain.escala.personalizada.EscalaPersonalizada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "escala_personalizada_dias")
@Entity(name = "EscalaPersonalizadaDias")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EscalaPersonalizadaDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escala_personalizada")
    private EscalaPersonalizada escalaPersonalizada;
    private String nome;
    private Integer numero_intercessores;
    @Enumerated(EnumType.STRING)
    private DiasDaSemana dia_semana;
}