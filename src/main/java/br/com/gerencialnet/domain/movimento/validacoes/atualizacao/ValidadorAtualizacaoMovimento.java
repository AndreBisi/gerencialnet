package br.com.gerencialnet.domain.movimento.validacoes.atualizacao;

import br.com.gerencialnet.domain.movimento.AtualizacaoMovimentoDTO;

public interface ValidadorAtualizacaoMovimento {
	
	void validar(AtualizacaoMovimentoDTO dados);

}
