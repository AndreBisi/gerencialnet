package br.com.gerencialnet.domain.banco;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoBancoDTO(
		
		@NotNull
        Long id,
        
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        
        int codigoFebraban,
        
		int digitoFebraban) {

}
