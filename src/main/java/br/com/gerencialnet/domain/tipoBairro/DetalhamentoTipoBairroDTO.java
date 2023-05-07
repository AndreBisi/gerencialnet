package br.com.gerencialnet.domain.tipoBairro;

public record DetalhamentoTipoBairroDTO(Long id, String nome, String abreviacao) {
	
	public DetalhamentoTipoBairroDTO(TipoBairro tipoBairro) {
		this(tipoBairro.getId(), tipoBairro.getNome(), tipoBairro.getAbreviacao());
		
	}

}
