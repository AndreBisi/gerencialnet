package br.com.gerencialnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerencialnet.domain.cidade.AtualizacaoCidadeDTO;
import br.com.gerencialnet.domain.cidade.CadastroCidadeDTO;
import br.com.gerencialnet.domain.cidade.Cidade;
import br.com.gerencialnet.domain.cidade.CidadeRepository;
import br.com.gerencialnet.domain.cidade.DetalhamentoCidadeDTO;
import br.com.gerencialnet.domain.cidade.ListagemCidadeDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidade")			
@SecurityRequirement(name = "bearer-key")
public class CidadeController {

	@Autowired
	private CidadeRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroCidadeDTO dados, UriComponentsBuilder uriBuilder) {
		var cidade = new Cidade(dados);
		repository.save(cidade);
		var uri = uriBuilder.path("/cidade/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhamentoCidadeDTO(cidade));
	}

	@GetMapping
	public ResponseEntity<Page<ListagemCidadeDTO>> listar(
			@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		// @PageableDefault(size = 10, sort = {"nome"})
		// o size padrão é 20
		// sort não tem padrão

		var page = repository.findAll(paginacao).map(ListagemCidadeDTO::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoCidadeDTO dados) {
		var cidade = repository.getReferenceById(dados.id());

		cidade.atualizarInformacoes(dados);

		return ResponseEntity.ok(new DetalhamentoCidadeDTO(cidade));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		var cidade = repository.getReferenceById(id);

		return ResponseEntity.ok(new DetalhamentoCidadeDTO(cidade));
	}

}
