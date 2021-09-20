package br.com.south.system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que corresponde a uma Pauta (Assunto) na qual será tratado durante a votação.
 */

@Entity
public class Pauta {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@NotNull
	@NotEmpty
	private String assunto;

	@OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL)
	private List<Associado> associados = new ArrayList<>();

	private boolean ativa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public List<Associado> getAssociados() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
}
