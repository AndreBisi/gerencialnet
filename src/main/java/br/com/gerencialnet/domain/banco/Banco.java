package br.com.gerencialnet.domain.banco;

import java.math.BigDecimal;

import br.com.gerencialnet.domain.servico.AtualizacaoServicoDTO;
import br.com.gerencialnet.domain.servico.Servico;
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

@Table(name="tbbanco")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Banco {

	@Id
	@Column(name="bancocod", nullable = false)
	@SequenceGenerator(name="sqbanco", sequenceName="sqbanco", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqbanco")
	private Long id;
	
	@Column(name="banconome")
	private String nome;
	
	@Column(name="bancocodfeb")
	private int codigoFebraban;
	
	@Column(name="bancodigfeb")
	private int digitoFebraban;
	
	public Banco(CadastroBancoDTO dados) {
		
		this.nome = dados.nome();
		this.codigoFebraban = dados.codigoFebraban();
		this.digitoFebraban = dados.digitoFebraban();
	}
    public void atualizarInformacoes(AtualizacaoBancoDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        
        this.codigoFebraban = dados.codigoFebraban();
        this.digitoFebraban = dados.digitoFebraban();
    }
	
}
