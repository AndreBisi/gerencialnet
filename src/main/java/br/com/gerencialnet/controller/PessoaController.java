package br.com.gerencialnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerencialnet.domain.pessoa.DetalhamentoPessoaDTO;
import br.com.gerencialnet.domain.pessoa.PessoaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RequestMapping("/pessoa")
@RestController
@SecurityRequirement(name = "bearer-key")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;
	
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var pessoa = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoPessoaDTO(pessoa));
    }
}
