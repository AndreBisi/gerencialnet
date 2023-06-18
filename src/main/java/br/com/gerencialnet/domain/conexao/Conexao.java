package br.com.gerencialnet.domain.conexao;

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

@Table(name="tbconexao")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conexao {
	
    @Id
    @Column(name="conexaocod", nullable = false)
    @SequenceGenerator(name="sqconexao", sequenceName = "sqconexao", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqconexao")
	private Long id;
	
    @Column(name="conexaodesc")
	private String descricao;
    
    public Conexao(CadastroConexaoDTO dados) {
    	
    	this.descricao = dados.descricao();
    	
    }
    
    public void atualizaInformacoes(AtualizacaoConexaoDTO dados) {
    	
    	this.descricao = dados.descricao();
    	
    }

}
