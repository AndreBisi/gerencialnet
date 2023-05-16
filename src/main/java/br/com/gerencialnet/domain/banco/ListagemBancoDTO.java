package br.com.gerencialnet.domain.banco;

public record ListagemBancoDTO(Long id, String nome, int codigoFebraban, int digitoFebraban) {
	
	public ListagemBancoDTO(Banco banco) {
		
		this(banco.getId(), banco.getNome(), banco.getCodigoFebraban(), banco.getCodigoFebraban());
		
	} 

}
