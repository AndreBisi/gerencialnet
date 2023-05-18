package br.com.gerencialnet.domain.tecnico;

import br.com.gerencialnet.domain.vendedor.Vendedor;
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

@Table(name="tbtecnico")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tecnico {
	
	@Id
	@Column(name="tecnicocod", nullable = false)
	@SequenceGenerator(name="sqtecnico", sequenceName="sqtecnico", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqtecnico")	
	private Long id;
	
	@Column(name="tecniconome")
	private String nome;
	
	@Column(name="tecnicoativo")
	private Boolean ativo;
	
	public Tecnico(CadastroTecnicoDTO dados) {
		this.nome = dados.nome();
		this.ativo = dados.ativo();
	}
	
	public void atualizarInformacoes(AtualizacaoTecnicoDTO dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		this.ativo = dados.ativo();
	}

}
