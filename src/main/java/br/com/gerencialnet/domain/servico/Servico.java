package br.com.gerencialnet.domain.servico;

import java.math.BigDecimal;

import br.com.gerencialnet.domain.logradouro.AtualizacaoLogradouroDTO;
import br.com.gerencialnet.domain.movimento.Movimento;
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

@Table(name="tbservico")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico {	
	
	@Id
	@Column(name="servicocod", nullable = false)
	@SequenceGenerator(name="sqservico", sequenceName="sqservico", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqservico")
	private Long id;
	
	@Column(name="serviconome")
	private String nome;
	
	@Column(name="servicocobrar")
	private Boolean cobrar;
	
	@Column(name="servicovalor")
	private BigDecimal valor;
	
	@Column(name="servicoadesao")
	private Boolean adesao;
	
	public Servico(CadastroServicoDTO dados) {
		this.nome = dados.nome();
		this.cobrar = dados.cobrar();
		this.valor = dados.valor();
		this.adesao = dados.adesao();
	}
	
    public void atualizarInformacoes(AtualizacaoServicoDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        
        this.cobrar = dados.cobrar();
        this.valor = dados.valor();
        this.adesao = dados.adesao();

    }

}
