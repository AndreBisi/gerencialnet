package br.com.gerencialnet.domain.logradouro;

public record DetalhamentoLogradouroDTO(Long id, String nome, String abreviacao) {

    public DetalhamentoLogradouroDTO(Logradouro logradouro){
        this(logradouro.getId(), logradouro.getNome(), logradouro.getAbreviacao());
    }
}
