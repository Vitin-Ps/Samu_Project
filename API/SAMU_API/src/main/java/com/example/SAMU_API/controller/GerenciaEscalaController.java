package com.example.SAMU_API.controller;

import com.example.SAMU_API.domain.escala.configuracao.DadosRegistraConfiguracaoEscala;
import com.example.SAMU_API.domain.escala.personalizada.DadosListagemEscalaPesonalizada;
import com.example.SAMU_API.domain.escala.personalizada.EscalaPersonalizada;
import com.example.SAMU_API.domain.escala.personalizada.dias.DadosListagemEscalaPesonalizadaDia;
import com.example.SAMU_API.domain.escala.personalizada.dias.DadosRegistroEscalaPesonalizadaDia;
import com.example.SAMU_API.domain.escala.personalizada.dias.EscalaPersonalizadaDia;
import com.example.SAMU_API.repository.EscalaPersonalizadaDiaRepository;
import com.example.SAMU_API.repository.EscalaPersonalizadaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gerencia")
public class GerenciaEscalaController {
    @Autowired
    public EscalaPersonalizadaRepository escalaPersonalizadaRepository;

    @Autowired
    public EscalaPersonalizadaDiaRepository escalaPersonalizadaDiaRepository;


    @PostMapping("/personalizada")
    @Transactional
    public ResponseEntity<DadosListagemEscalaPesonalizada> cadastrarEscalaPersonalizada (@RequestBody String nome) {
        EscalaPersonalizada escalaPersonalizada = new EscalaPersonalizada(null , nome);
        escalaPersonalizada = escalaPersonalizadaRepository.save(escalaPersonalizada);
        return ResponseEntity.ok(new DadosListagemEscalaPesonalizada(escalaPersonalizada));
    }

    @PostMapping("/personalizada/dias")
    @Transactional
    public ResponseEntity<DadosListagemEscalaPesonalizadaDia> cadastrarEscalaPersonalizadaDia (@RequestBody @Valid DadosRegistroEscalaPesonalizadaDia dados) {
        EscalaPersonalizada escalaPersonalizada = escalaPersonalizadaRepository.getReferenceById(dados.id_escala_personalizada());

        EscalaPersonalizadaDia escalaPersonalizadaDia = new EscalaPersonalizadaDia(null, escalaPersonalizada, dados.nome(), dados.numero_intercessores(), dados.dia_semana());
        escalaPersonalizadaDia = escalaPersonalizadaDiaRepository.save(escalaPersonalizadaDia);
        return ResponseEntity.ok(new DadosListagemEscalaPesonalizadaDia(escalaPersonalizadaDia));
    }
}
