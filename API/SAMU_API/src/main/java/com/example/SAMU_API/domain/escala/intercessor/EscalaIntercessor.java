package com.example.SAMU_API.domain.escala.intercessor;

import com.example.SAMU_API.domain.escala.Escala;
import com.example.SAMU_API.domain.intercessor.Intercessor;
import com.example.SAMU_API.domain.intercessor.TipoIntercessor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "escala_intercessor")
@Entity(name = "EscalaIntercessor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EscalaIntercessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_intercessor")
    private Intercessor intercessor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escala")
    private Escala escala;
    private TipoIntercessor tipoIntercessor;
}