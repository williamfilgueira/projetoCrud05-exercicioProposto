package org.serrratec.backand.services;

import java.util.List;
import java.util.Optional;

import org.serrratec.backand.models.AutorEntity;
import org.serrratec.backand.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class AutorService {

	@Autowired
	AutorRepository repository;

	public List<AutorEntity> getAll() {
		return repository.findAll();
	}

	// metodo findId
	public AutorEntity getById(Long id) throws NotFoundException {
		Optional<AutorEntity> autor = repository.findById(id);

		if (autor.isEmpty()) {
			throw new NotFoundException("Não encontrado");
		}
		return autor.get();
	}

//metodo create
	public AutorEntity create(AutorEntity autor) {
		return repository.save(autor);
	}

	public AutorEntity update(Long id, AutorEntity autor) throws NotFoundException {
		AutorEntity autorEntity = this.getById(id);

		if (autor.getNome() != null) {
			autorEntity.setNome(autor.getNome());
		}
		return repository.save(autorEntity);
	}

//metodo delete
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
