package br.com.gerencialnet.domain.movimento;

public record DetalhamentoMovimentoDTO(Long id, String nome, Boolean ativo, String sinal, Boolean pagamento, Boolean recebimento) {

	public DetalhamentoMovimentoDTO(Movimento movimento) {
		this(
				movimento.getId(), 
				movimento.getNome(), 
				movimento.getAtivo(), 
				movimento.getSinal(), 
				movimento.getRecebimento(), 
				movimento.getPagamento()
			);
	}
	
}
