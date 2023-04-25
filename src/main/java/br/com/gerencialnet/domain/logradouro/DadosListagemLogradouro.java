package br.com.gerencialnet.domain.logradouro;

public record DadosListagemLogradouro(Long id, String nome, String abreviacao) {

    public DadosListagemLogradouro(Logradouro logradouro){
        this(logradouro.getId(), logradouro.getNome(), logradouro.getAbreviacao());
    }

}
