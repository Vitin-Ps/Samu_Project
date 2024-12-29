package com.example.SAMU_API.domain.intercessor;

public record DadosListagemIntecessor(
        Long id,
        String nome,
        Integer idade,
        String telefone

) {
    public DadosListagemIntecessor(Intercessor intercessor) {
        this(intercessor.getId(), intercessor.getNome(), intercessor.getIdade(), intercessor.getTelefone());
    }
}
