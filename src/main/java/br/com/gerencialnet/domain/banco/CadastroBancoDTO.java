package br.com.gerencialnet.domain.banco;

import jakarta.validation.constraints.NotBlank;

public record CadastroBancoDTO(
		
		@NotBlank(message = "O nome é obrigatório")
        String nome,

        int codigoFebraban,
        
		int digitoFebraban) {

}
