package org.serrratec.backand.services;

import java.util.List;
import java.util.Optional;

import org.serrratec.backand.models.CategoriaEntity;
import org.serrratec.backand.models.LivroEntity;
import org.serrratec.backand.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

//	metodo getAll
	public List<CategoriaEntity> getAll() {
		return repository.findAll();
	}

//	metodo getID
	public CategoriaEntity getById(Long id) throws NotFoundException {
		Optional<CategoriaEntity> categoria = repository.findById(id);
		if (categoria.isEmpty()) {
			throw new NotFoundException("Não encontrado");
		}
		return categoria.get();
	}

//metodo create
	public CategoriaEntity create(CategoriaEntity categoria) {
		return repository.save(categoria);
	}

//metodo para update
	public CategoriaEntity update(Long id, CategoriaEntity categoria) throws NotFoundException {
		CategoriaEntity categoriaEntity = this.getById(id);

		if (categoriaEntity.getNome() != null) {
			categoriaEntity.setNome(categoria.getNome());
		}
		if (categoria.getDescricao() != null) {
			categoria.setDescricao(categoria.getDescricao());
		}

		return repository.save(categoriaEntity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}


}
