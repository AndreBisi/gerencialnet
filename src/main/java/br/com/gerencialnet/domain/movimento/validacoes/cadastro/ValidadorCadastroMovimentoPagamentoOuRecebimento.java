package br.com.gerencialnet.domain.movimento.validacoes.cadastro;

import org.springframework.stereotype.Component;

import br.com.gerencialnet.domain.ValidacaoException;
import br.com.gerencialnet.domain.movimento.CadastroMovimentoDTO;

@Component
public class ValidadorCadastroMovimentoPagamentoOuRecebimento implements ValidadorCadastroMovimento {

	public void validar(CadastroMovimentoDTO dados) {
		if(!dados.pagamento() && !dados.recebimento()){
			
			throw new ValidacaoException("O movimento deve ser indicado ao menos para uma finalidade");
			
		}
	}
	
}
