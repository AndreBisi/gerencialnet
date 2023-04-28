package br.com.gerencialnet.domain.movimento;

public record ListagemMovimentoDTO(Long id, String nome, Boolean ativo, String sinal, Boolean recebimento, Boolean pagamento) {

	public ListagemMovimentoDTO(Movimento movimento) {
		this(movimento.getId(), movimento.getNome(), movimento.getAtivo(), movimento.getSinal(), movimento.getRecebimento(), movimento.getPagamento());
		
	}
	
}
