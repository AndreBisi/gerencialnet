package br.com.gerencialnet.domain.tecnico;

public record ListagemTecnicoDTO(Long id, String nome, Boolean ativo) {
	
	public ListagemTecnicoDTO(Tecnico tecnico) {
		this(
				tecnico.getId(),
				tecnico.getNome(),
				tecnico.getAtivo()				
				);
	}

}
