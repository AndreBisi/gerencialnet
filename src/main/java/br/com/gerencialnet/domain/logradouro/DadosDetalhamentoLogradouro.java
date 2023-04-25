package br.com.gerencialnet.domain.logradouro;

public record DadosDetalhamentoLogradouro(Long id, String nome, String abreviacao) {

    public DadosDetalhamentoLogradouro(Logradouro logradouro){
        this(logradouro.getId(), logradouro.getNome(), logradouro.getAbreviacao());
    }
}
