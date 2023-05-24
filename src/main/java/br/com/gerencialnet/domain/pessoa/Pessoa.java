package br.com.gerencialnet.domain.pessoa;

import java.time.LocalDateTime;

import br.com.gerencialnet.domain.vendedor.AtualizacaoVendedorDTO;
import br.com.gerencialnet.domain.vendedor.CadastroVendedorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="tbpessoa")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
	
	@Id
	@Column(name="pessoacod", nullable=false)
	@SequenceGenerator(name="sqpessoa", sequenceName="sqpessoa", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqpessoa")
	private Long id;
	
	@Column(name="pessoatipo")
	private String tipo;
	
	@Column(name="pessoanome")
	private String nome;
	
	@Column(name="pessoarazao")
	private String razaoSocial;
	
	@Column(name="pessoarg")
	private String rg;
	
	@Column(name="pessoacpf")
	private String cpf;
	
	@Column(name="pessoacnpj")
	private String cnpj;
	
	@Column(name="pessoaie")
	private String inscricaoEstadual;
	
	@Column(name="pessoaativo")
	private Boolean ativo;
	
	@Column(name="pessoadatanasc")
	private LocalDateTime dataNascimento;
	
	@Column(name="pessoadatacad")	
	private LocalDateTime dataCadastro;
	
	@Column(name="pessoatelefone")
	private String telefone;
	
	@Column(name="pessoacelular")
	private String celular;
	
	@Column(name="pessoafax")
	private String fax;
	
	@Column(name="pessoaemail")
	private String email;
	
	@Column(name="pessoasite")
	private String site;
	
	@Column(name="pessoaobs")
	private String observacao;
	
	@Column(name="pessoaim")
	private String inscricaoMunicipal;
	
	@Column(name="pessoaboletoemail")
	private Boolean boletoPorEmail;
	

	public Pessoa(CadastroPessoaDTO dados) {
		this.nome = dados.nome();
		this.tipo = dados.tipo();
		
		if(dados.tipo().equals("F")) {
			this.razaoSocial = null;
			this.cnpj = null;
			this.dataNascimento = dados.dataNascimento();
			this.rg = dados.rg();
			this.cpf = dados.cpf();
			this.inscricaoEstadual = null;
			this.inscricaoMunicipal = null;
		}else {
			this.razaoSocial = dados.razaoSocial();
			this.cnpj = dados.cnpj();
			this.dataNascimento = null;
			this.rg = null;
			this.cpf = null;
			this.inscricaoEstadual = dados.inscricaoEstadual();
			this.inscricaoMunicipal = dados.inscricaoMunicipal();			
		}
				
		this.ativo = dados.ativo();
		this.dataCadastro = LocalDateTime.now();
		this.telefone = dados.telefone();
		this.celular = dados.celular();
		this.fax = dados.fax();
		this.email = dados.email();
		this.site = dados.site();
		this.observacao = dados.observacao();
		this.boletoPorEmail = dados.boletoPorEmail();
		
	}
	
	public void atualizarInformacoes(AtualizacaoPessoaDTO dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		this.tipo = dados.tipo();
		
		if(dados.tipo().equals("F")) {
			this.razaoSocial = null;
			this.cnpj = null;
			this.dataNascimento = dados.dataNascimento();
			this.rg = dados.rg();
			this.cpf = dados.cpf();
			this.inscricaoEstadual = null;
			this.inscricaoMunicipal = null;
		}else {
			this.razaoSocial = dados.razaoSocial();
			this.cnpj = dados.cnpj();
			this.dataNascimento = null;
			this.rg = null;
			this.cpf = null;
			this.inscricaoEstadual = dados.inscricaoEstadual();
			this.inscricaoMunicipal = dados.inscricaoMunicipal();			
		}
				
		this.ativo = dados.ativo();
		this.dataCadastro = LocalDateTime.now();
		this.telefone = dados.telefone();
		this.celular = dados.celular();
		this.fax = dados.fax();
		this.email = dados.email();
		this.site = dados.site();
		this.observacao = dados.observacao();
		this.boletoPorEmail = dados.boletoPorEmail();

	}

}
