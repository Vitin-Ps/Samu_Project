package com.example.SAMU_API.controller;


import com.example.SAMU_API.domain.intercessor.DadosListagemIntecessor;
import com.example.SAMU_API.domain.intercessor.DadosRegistroIntercessor;
import com.example.SAMU_API.domain.intercessor.Intercessor;
import com.example.SAMU_API.domain.intercessor.indisponibilidade.DadosIndisponibilidadeIntercessor;
import com.example.SAMU_API.domain.intercessor.indisponibilidade.DadosListagemIntecessorIndisponibilidade;
import com.example.SAMU_API.domain.intercessor.indisponibilidade.IntercessorIndisponibilidade;
import com.example.SAMU_API.repository.IntercessorIndisponibilidadeRepository;
import com.example.SAMU_API.repository.IntercessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("intercessor")
public class IntercessorController {
    @Autowired
    private IntercessorRepository intercessorRepository;

    @Autowired
    private IntercessorIndisponibilidadeRepository intercessorIndisponibilidadeRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemIntecessor> cadastrar(@RequestBody @Valid DadosRegistroIntercessor dados) {
        Intercessor intercessor = new Intercessor(null, dados.nome(), dados.idade(), dados.telefone(), true);
        intercessor = intercessorRepository.save(intercessor);

        return ResponseEntity.ok(new DadosListagemIntecessor(intercessor));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemIntecessor>> listar() {
        List<Intercessor> intercessors = intercessorRepository.findAll();
        return ResponseEntity.ok(intercessors.stream().map(DadosListagemIntecessor::new).toList());
    }

    @PostMapping("/indisponibilidade")
    @Transactional
    public ResponseEntity<DadosListagemIntecessorIndisponibilidade> addIndisponibilidade(@RequestBody @Valid DadosIndisponibilidadeIntercessor dados) {
        Intercessor intercessor = intercessorRepository.getReferenceByIdAndAtivoTrue(dados.id_intercessor());
        IntercessorIndisponibilidade intercessorIndisponibilidade = new IntercessorIndisponibilidade(null, intercessor, dados.dia());
        intercessorIndisponibilidadeRepository.save(intercessorIndisponibilidade);

        return ResponseEntity.ok(new DadosListagemIntecessorIndisponibilidade(intercessorIndisponibilidade));
    }
}
