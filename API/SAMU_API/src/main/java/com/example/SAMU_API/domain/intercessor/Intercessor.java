package com.example.SAMU_API.domain.intercessor;

import com.example.SAMU_API.domain.escala.Escala;
import com.example.SAMU_API.domain.intercessor.Intercessor;
import com.example.SAMU_API.domain.intercessor.TipoIntercessor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "intercessor")
@Entity(name = "Intercessor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Intercessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String telefone;
}