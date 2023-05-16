package br.com.gerencialnet.domain.bairro;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.tipoBairro.DetalhamentoTipoBairroDTO;
import br.com.gerencialnet.domain.tipoBairro.TipoBairro;

public record DetalhamentoBairroDTO(Long id, String nome, DetalhamentoTipoBairroDTO tipoBairro) {
	
	public DetalhamentoBairroDTO(Bairro bairro) {
		this(
				bairro.getId(),
				bairro.getNome(),
				bairro.getTipoBairro() != null ? new DetalhamentoTipoBairroDTO(bairro.getTipoBairro()) : null
			);
	}

}
