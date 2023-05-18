package br.com.gerencialnet.domain.tecnico;

public record DetalhamentoTecnicoDTO(Long id, String nome, Boolean ativo) {
	
	public DetalhamentoTecnicoDTO(Tecnico tecnico) {
		this(
				tecnico.getId(),
				tecnico.getNome(),
				tecnico.getAtivo()				
				);		
	}

}
