package com.example.SAMU_API.domain.intercessor.indisponibilidade;

import com.example.SAMU_API.domain.intercessor.Intercessor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "intercessor_indisponibilidade")
@Entity(name = "IntercessorIndisponibilidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class IntercessorIndisponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_intercessor")
    private Intercessor intercessor;
    private LocalDateTime dia;
}