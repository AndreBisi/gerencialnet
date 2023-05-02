package br.com.gerencialnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerencialnet.domain.cidade.DetalhamentoCidadeDTO;
import br.com.gerencialnet.domain.logradouro.LogradouroRepository;
import br.com.gerencialnet.domain.rua.DetalhamentoRuaDTO;
import br.com.gerencialnet.domain.rua.RuaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/rua")
@SecurityRequirement(name = "bearer-key")
public class RuaController {
	
	@Autowired
	private RuaRepository ruaRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		
		var rua = ruaRepository.getReferenceById(id);

		return ResponseEntity.ok(new DetalhamentoRuaDTO(rua));
	}
	

}
