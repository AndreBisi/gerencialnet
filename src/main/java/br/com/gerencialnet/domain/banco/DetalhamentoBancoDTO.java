package br.com.gerencialnet.domain.banco;

public record DetalhamentoBancoDTO(Long id, String nome, int codigoFebraban, int digitoFebraban) {
	
	public DetalhamentoBancoDTO(Banco banco) {
		
		this(banco.getId(), banco.getNome(), banco.getCodigoFebraban(), banco.getDigitoFebraban());
		
	}
	

}
