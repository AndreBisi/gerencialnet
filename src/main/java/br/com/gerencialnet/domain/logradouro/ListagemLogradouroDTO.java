package br.com.gerencialnet.domain.logradouro;

public record ListagemLogradouroDTO(Long id, String nome, String abreviacao) {

    public ListagemLogradouroDTO(Logradouro logradouro){
        this(logradouro.getId(), logradouro.getNome(), logradouro.getAbreviacao());
    }

}
