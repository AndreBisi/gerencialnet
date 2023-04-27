package br.com.gerencialnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.movimento.CadastroMovimentoDTO;
import br.com.gerencialnet.domain.movimento.DetalhamentoMovimentoDTO;
import br.com.gerencialnet.domain.movimento.Movimento;
import br.com.gerencialnet.domain.movimento.MovimentoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimento")
@SecurityRequirement(name = "bearer-key")
public class MovimentoController {
	
	@Autowired
	private MovimentoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroMovimentoDTO dados, UriComponentsBuilder uriBuilder) {
		var movimento = new Movimento(dados);
		
		repository.save(movimento);
		
		var uri = uriBuilder.path("/movimento/{id}").buildAndExpand(movimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhamentoMovimentoDTO(movimento));
	}
	
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var movimento = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoMovimentoDTO(movimento));
    }
}
