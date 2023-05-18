package br.com.gerencialnet.domain.vendedor;

import br.com.gerencialnet.domain.servico.Servico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Table(name="tbvendedor")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendedor {
	
	@Id
	@Column(name="vendedorcod", nullable = false)
	@SequenceGenerator(name="sqvendedor", sequenceName="sqvendedor", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqvendedor")
	private Long id;
	
	@Column(name="vendedornome")
	private String nome;
	
	@Column(name="vendedorativo")
	private Boolean ativo;
	
	public Vendedor(CadastroVendedorDTO dados) {
		this.nome = dados.nome();
		this.ativo = dados.ativo();		
	}
	
	public void atualizarInformacoes(AtualizacaoVendedorDTO dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		this.ativo = dados.ativo();
	}

}
