package br.com.gerencialnet.domain.vendedor;

public record ListagemVendedorDTO(Long id, String nome, Boolean ativo) {
	
	public ListagemVendedorDTO(Vendedor vendedor) {
		
		this(vendedor.getId(), vendedor.getNome(), vendedor.getAtivo());
		
	}

}
