package com.example.SAMU_API.controller;

import com.example.SAMU_API.domain.escala.DadosAddEscala;
import com.example.SAMU_API.domain.escala.DadosListagemEscala;
import com.example.SAMU_API.domain.escala.DadosListagemEscalaConfiguracao;
import com.example.SAMU_API.domain.escala.EscalaService;
import com.example.SAMU_API.domain.escala.configuracao.DadosRegistraConfiguracaoEscala;
import com.example.SAMU_API.repository.EscalaPersonalizadaDiaRepository;
import com.example.SAMU_API.repository.EscalaPersonalizadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escala")
public class EscalaController {
    @Autowired
    public EscalaPersonalizadaRepository escalaPersonalizadaRepository;

    @Autowired
    public EscalaPersonalizadaDiaRepository escalaPersonalizadaDiaRepository;

    @Autowired
    public EscalaService escalaService;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemEscalaConfiguracao> cadastrarEscala(@RequestBody DadosRegistraConfiguracaoEscala dados) {
        DadosListagemEscalaConfiguracao escalaConfiguracao = escalaService.registraConfiguracaoEscala(dados);
        return ResponseEntity.ok(escalaConfiguracao);
    }

    @PostMapping("add-escala")
    @Transactional
    public ResponseEntity<DadosListagemEscala> addEscala(@RequestBody DadosAddEscala dados) {
        DadosListagemEscala escala = escalaService.addEscala(dados);
        return ResponseEntity.ok(escala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemEscalaConfiguracao> detalharEscalaConfiguracao(@PathVariable Long id) {
        DadosListagemEscalaConfiguracao escalaConfiguracao = escalaService.detalharEscalasPorConfiguracao(id);
        return ResponseEntity.ok(escalaConfiguracao);
    }

    @GetMapping("/montar/{id}")
    @Transactional
    public ResponseEntity<DadosListagemEscalaConfiguracao> montarEscalaConfiguracao(@PathVariable Long id) {
        escalaService.monstarEscala(id);
        return ResponseEntity.ok().build();
    }
}
