package br.com.gerencialnet.domain.rua;

import br.com.gerencialnet.domain.logradouro.Logradouro;
import jakarta.annotation.Nullable;
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
	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="logradourocod")
    @Embedded
	private Logradouro logradouro;

}
