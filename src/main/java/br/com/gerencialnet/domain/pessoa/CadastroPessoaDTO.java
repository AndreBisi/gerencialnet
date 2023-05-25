package br.com.gerencialnet.domain.pessoa;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroPessoaDTO(
		
		@NotBlank
		String tipo,
		
		@NotBlank
		String nome,
		
		String razaoSocial,
		
		String rg,
		
		@CPF
		String cpf,
		
		@CNPJ
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
		
		Boolean boletoPorEmail
		) {

}
