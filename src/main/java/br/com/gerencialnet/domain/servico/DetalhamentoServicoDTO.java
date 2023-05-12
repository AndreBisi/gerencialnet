package br.com.gerencialnet.domain.servico;

import java.math.BigDecimal;

public record DetalhamentoServicoDTO(Long id, String nome, Boolean cobrar, BigDecimal valor, Boolean adesao) {
	
	public DetalhamentoServicoDTO(Servico servico) {
		this(
				servico.getId(),
				servico.getNome(),
				servico.getCobrar(),
				servico.getValor(),
				servico.getAdesao()				
				);		
		
	}

}
