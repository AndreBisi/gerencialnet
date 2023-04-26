package br.com.gerencialnet.domain.cidade;

public record ListagemCidadeDTO(Long id, String nome, String uf, String ibge) {
	
	public ListagemCidadeDTO(Cidade cidade) {
		this(cidade.getId(), cidade.getNome(), cidade.getUf(), cidade.getIbge());
	}

}
