package br.com.gerencialnet.domain.cidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tbcidade")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade {
	
    @Id
    @Column(name="cidadecod", nullable = false)
    @SequenceGenerator(name="sqcidade", sequenceName = "sqcidade", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqcidade")
	private Long id;
	
    @Column(name="cidadenome")
	private String nome;
    
    @Column(name="cidadeuf")
	private String uf;
    
    @Column(name="cidadeibge")
	private String ibge;

	public Cidade(CadastroCidadeDTO dados) {
		this.nome = dados.nome();
		this.uf = dados.uf();
		this.ibge = dados.ibge();
	}
	
    public void atualizarInformacoes(AtualizacaoCidadeDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.uf() != null){
            this.uf = dados.uf();
        }
            
        if(dados.ibge() != null) {
        	this.ibge = dados.ibge();
        }
    }
    
}
