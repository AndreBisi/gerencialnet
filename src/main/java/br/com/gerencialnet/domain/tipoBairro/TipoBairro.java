package br.com.gerencialnet.domain.tipoBairro;

import br.com.gerencialnet.domain.logradouro.AtualizacaoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;
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

@Table(name = "tbtipobairro")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoBairro {
	
    @Id
    @Column(name="tipobairrocod", nullable = false)
    @SequenceGenerator(name="sqtipobairro", sequenceName = "sqtipobairro", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqtipobairro")
	private Long id;
	
    @Column(name="tipobairronome")
	private String nome;
	
    @Column(name="tipobairroabrev")
	private String abreviacao;
    
    public TipoBairro(CadastroTipoBairroDTO dados) {
    	this.nome = dados.nome();
    	this.abreviacao = dados.abreviacao();    	
    }
    
    public void atualizarInformacoes(AtualizacaoTipoBairroDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        
        this.abreviacao = dados.abreviacao();

    }

}
