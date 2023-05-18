package br.com.gerencialnet.domain.vendedor;

public record DetalhamentoVendedorDTO(Long id, String nome, Boolean ativo) {
	
	public DetalhamentoVendedorDTO(Vendedor vendedor) {
		
		this(
				vendedor.getId(),
				vendedor.getNome(),
				vendedor.getAtivo()				
				);		
	}

}
