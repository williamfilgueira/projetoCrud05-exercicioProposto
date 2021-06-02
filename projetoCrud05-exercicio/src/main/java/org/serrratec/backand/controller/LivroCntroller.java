package org.serrratec.backand.controller;

import java.util.List;

import org.serrratec.backand.models.LivroEntity;
import org.serrratec.backand.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/livro")
public class LivroCntroller {

	@Autowired
	LivroService service;
	
	@GetMapping
	public List<LivroEntity> getlAll(){
		return service.getAll();
	}
	
	@GetMapping("/id")
	public LivroEntity getById(@PathVariable("id") Long id) throws NotFoundException {
		return service.getById(id);
	}
	
	
}
