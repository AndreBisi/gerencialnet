package br.com.gerencialnet.domain.cidade;

public record DetalhamentoCidadeDTO(Long id, String nome, String uf, String ibge) {
	
	public DetalhamentoCidadeDTO(Cidade cidade) {
		this(cidade.getId(), cidade.getUf(), cidade.getNome(), cidade.getIbge());
	}

}
