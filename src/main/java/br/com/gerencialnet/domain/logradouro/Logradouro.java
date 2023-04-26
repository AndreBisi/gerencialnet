package br.com.gerencialnet.domain.logradouro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "tblogradouro")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Logradouro {

    @Id
    @Column(name="logradourocod", nullable = false)
    @SequenceGenerator(name="sqlogradouro", sequenceName = "sqlogradouro", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqlogradouro")
    private Long id;

    @Column(name="logradouronome")
    private String nome;

    @Column(name="logradouroabrev")
    private String abreviacao;

    public Logradouro(CadastroLogradouroDTO dados) {
        this.nome = dados.nome();
        this.abreviacao = dados.abreviacao();
    }

    public void atualizarInformacoes(AtualizacaoLogradouroDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.abreviacao() != null){
            this.abreviacao = dados.abreviacao();
        }
    }
}
