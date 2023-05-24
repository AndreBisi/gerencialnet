package br.com.gerencialnet.domain.pessoa;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoPessoaDTO(
		@NotNull
		Long id,
		
		@NotBlank
		String tipo,
		
		@NotBlank
		String nome,
		
		String razaoSocial,
		
		String rg,
		
		String cpf,
		
		String cnpj,
		
		String inscricaoEstadual,
		
		Boolean ativo,
		
		LocalDateTime dataNascimento,
		
		String telefone,

		String celular,
		
		String fax,
		
		@Email
		String email,
		
		String site,
		
		String observacao,
		
		String inscricaoMunicipal,
		
		Boolean boletoPorEmail) {

}
