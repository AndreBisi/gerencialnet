package br.com.gerencialnet.domain.movimento.validacoes.cadastro;

import br.com.gerencialnet.domain.movimento.CadastroMovimentoDTO;

public interface ValidadorCadastroMovimento {
	
	void validar(CadastroMovimentoDTO dados);

}
