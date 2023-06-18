package br.com.gerencialnet.domain.conexao;

public record ListagemConexaoDTO(Long id, String descricao) {
	
	public ListagemConexaoDTO(Conexao conexao) {		
		this( conexao.getId(), conexao.getDescricao() );		
	}

}
