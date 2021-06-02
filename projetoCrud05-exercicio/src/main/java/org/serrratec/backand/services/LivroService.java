package org.serrratec.backand.services;

import java.util.List;
import java.util.Optional;

import org.serrratec.backand.models.LivroEntity;
import org.serrratec.backand.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class LivroService {

	@Autowired
	LivroRepository repository;

	public List<LivroEntity> getAll() {
		return repository.findAll();
	}

	public LivroEntity getById(Long id) throws NotFoundException {
		Optional<LivroEntity> livro = repository.findById(id);

		if (livro.isEmpty()) {
			throw new NotFoundException("Não encontrado");
		}
		return livro.get();
	}

	public LivroEntity create(LivroEntity livro) {
		return repository.save(livro);
	}

	public LivroEntity update(Long id, LivroEntity livro) throws NotFoundException {
		LivroEntity listaLivros = this.getById(id);

		if (livro.getNome() != null) {
			listaLivros.setNome(livro.getNome());
		}
		if (listaLivros.getAutores() != null) {
			listaLivros.setAutores(livro.getAutores());
		}
		if (livro.getCategoria() != null) {
			listaLivros.setCategoria(livro.getCategoria());
		}
		return repository.save(listaLivros);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
