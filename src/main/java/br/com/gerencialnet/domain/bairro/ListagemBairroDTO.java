package br.com.gerencialnet.domain.bairro;

import br.com.gerencialnet.domain.tipoBairro.DetalhamentoTipoBairroDTO;

public record ListagemBairroDTO(long id, String nome, DetalhamentoTipoBairroDTO tipoBairro) {
	
	public ListagemBairroDTO(Bairro bairro) {
		this(
				bairro.getId(),
				bairro.getNome(),
				bairro.getTipoBairro() != null ? new DetalhamentoTipoBairroDTO(bairro.getTipoBairro()) : null
				
			);
	}

}
