package br.com.gerencialnet.domain.pessoa;

import java.time.LocalDateTime;

public record DetalhamentoPessoaDTO(
		Long id, 
		String tipo,
		String nome,
		String razaoSocial,
		String rg,
		String cpf,
		String cnpj,
		String inscricaoEstadual,
		Boolean ativo,
		LocalDateTime dataNascimento,
		LocalDateTime dataCadastro,
		String telefone,
		String celular,
		String fax,
		String email,
		String site,
		String observacao,
		String inscricaoMunicipal,
		Boolean boletoPorEmail
		){
	
	public DetalhamentoPessoaDTO(Pessoa pessoa) {
		this(
				pessoa.getId(),
				pessoa.getTipo(),
				pessoa.getNome(),
				pessoa.getTipo().equals("J") ? pessoa.getRazaoSocial() : null,
				pessoa.getTipo().equals("F") ? pessoa.getRg() : null,
				pessoa.getTipo().equals("F") ? pessoa.getCpf() : null,
				pessoa.getTipo().equals("J") ? pessoa.getCnpj() : null,
			    pessoa.getTipo().equals("J") ? pessoa.getInscricaoEstadual() : null,
				pessoa.getAtivo(),
				pessoa.getTipo().equals("F") ? pessoa.getDataNascimento() : null,
				pessoa.getDataCadastro(),
				pessoa.getTelefone(),
				pessoa.getCelular(),
				pessoa.getFax(),
				pessoa.getEmail(),
				pessoa.getSite(),
				pessoa.getObservacao(),
				pessoa.getTipo().equals("J") ? pessoa.getInscricaoMunicipal() : null,
				pessoa.getBoletoPorEmail()

				);
	}

}
