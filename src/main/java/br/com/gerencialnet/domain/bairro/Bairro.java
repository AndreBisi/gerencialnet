package br.com.gerencialnet.domain.bairro;

import br.com.gerencialnet.domain.tipoBairro.TipoBairro;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tbbairro")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bairro {
	
	@Id
	@Column(name="bairrocod", nullable = false)
	@SequenceGenerator(name="sqbairro", sequenceName = "sqbairro", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sqbairro")
	private Long id;
	
	@Column(name="bairronome")
	private String nome;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tipobairrocod", nullable = true)
    @Embedded
	private TipoBairro tipoBairro;
	
}
