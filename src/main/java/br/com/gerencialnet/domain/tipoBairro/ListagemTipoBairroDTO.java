package br.com.gerencialnet.domain.tipoBairro;

public record ListagemTipoBairroDTO(Long id, String nome, String abreviacao) {

	public ListagemTipoBairroDTO(TipoBairro tipoBairro) {
		
		this(tipoBairro.getId(), tipoBairro.getNome(), tipoBairro.getAbreviacao());
		
	}

}
