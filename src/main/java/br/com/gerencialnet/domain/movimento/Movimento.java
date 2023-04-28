package br.com.gerencialnet.domain.movimento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tbmovimento")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimento {
	
	@Id
	@Column(name="movimentocod", nullable=false)
	@SequenceGenerator(name="sqmovimento", sequenceName="sqmovimento", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqmovimento")
	private Long id;
	
	@Column(name="movimentonome")
	private String nome;
	
	@Column(name="movimentoativo")
	private Boolean ativo;
	
	@Column(name="movimentosinal")
	private String sinal;
	
	@Column(name="movimentoctrec")
	private Boolean recebimento;
	
	@Column(name="movimentoctpag")
	private Boolean pagamento;
	
	public Movimento(CadastroMovimentoDTO dados) {
		
		this.nome = dados.nome();
		this.ativo = dados.ativo();
		this.sinal = dados.sinal();
		this.recebimento = dados.recebimento();
		this.pagamento = dados.pagamento();
		
	}
	
	public void atualizarInformacoes(AtualizacaoMovimentoDTO dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.ativo() != null) {
			this.ativo = dados.ativo();
		}
		
		if(dados.sinal() != null) {
			this.sinal = dados.sinal();
		}
		
		if(dados.recebimento() != null) {
			this.recebimento = dados.recebimento();
		}
		
		if(dados.pagamento() != null) {
			this.pagamento = dados.pagamento();
		}
	}	

}
