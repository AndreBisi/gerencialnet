package br.com.gerencialnet.domain.cidade;

import jakarta.validation.constraints.NotBlank;

public record CadastroCidadeDTO (
		
		@NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A UF é obrigatória")
        String uf,
        
		String ibge
		) {

}
