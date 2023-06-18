package br.com.gerencialnet.domain.conexao;

public record DetalhamentoConexaoDTO(Long id, String descricao) {
	
	public DetalhamentoConexaoDTO(Conexao conexao) {
		
		this( conexao.getId(), conexao.getDescricao() );
		
	}

}
