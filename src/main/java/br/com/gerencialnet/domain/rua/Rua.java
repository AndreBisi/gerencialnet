package br.com.gerencialnet.domain.rua;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gerencialnet.domain.logradouro.CadastroLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;
import br.com.gerencialnet.domain.logradouro.LogradouroRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tbrua")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rua {
	
    @Id
    @Column(name="ruacod", nullable = false)
    @SequenceGenerator(name="sqrua", sequenceName = "sqrua", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqrua")
	private Long id;
	
    @Column(name="ruanome")
	private String nome;
	
    @Column(name="ruacep")
	private String cep;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="logradourocod", nullable = true)
    @Embedded
    private Logradouro logradouro;
	
    public Rua(CadastroRuaDTO dados) {
        this.nome = dados.nome();
        this.cep = dados.cep();
        
        if(dados.logradouro() != null) {
        	
        	this.logradouro = dados.logradouro();
        }
    }

}
