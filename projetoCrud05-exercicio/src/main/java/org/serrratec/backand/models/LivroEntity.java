package org.serrratec.backand.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "LIVROS")
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@ManyToOne()
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private CategoriaEntity categoria;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="autor_id", referencedColumnName = "id"))
	private List<AutorEntity> autores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public List<AutorEntity> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorEntity> autores) {
		this.autores = autores;
	}

	
	
	
}
