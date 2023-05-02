package br.com.gerencialnet.domain.movimento.validacoes.atualizacao;

import br.com.gerencialnet.domain.ValidacaoException;
import br.com.gerencialnet.domain.movimento.AtualizacaoMovimentoDTO;

import org.springframework.stereotype.Component;


@Component
public class ValidadorAtualizacaoMovimentoPagamentoOuRecebimento implements ValidadorAtualizacaoMovimento {
	
	public void validar(AtualizacaoMovimentoDTO dados) {
		if(!dados.pagamento() && !dados.recebimento()){
			
			throw new ValidacaoException("O movimento deve ser indicado ao menos para uma finalidade");
			
		}
	}

}
