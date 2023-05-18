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

import br.com.gerencialnet.domain.bairro.AtualizacaoBairroDTO;
import br.com.gerencialnet.domain.bairro.BairroRepository;
import br.com.gerencialnet.domain.bairro.BairroService;
import br.com.gerencialnet.domain.bairro.CadastroBairroDTO;
import br.com.gerencialnet.domain.bairro.DetalhamentoBairroDTO;
import br.com.gerencialnet.domain.bairro.ListagemBairroDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bairro")
@SecurityRequirement(name = "bearer-key")
public class BairroController {
	
	@Autowired
	private BairroRepository repository;
	
	@Autowired
	private BairroService service;
	
	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {

		var bairro = repository.getReferenceById(id);

		return ResponseEntity.ok(new DetalhamentoBairroDTO(bairro));
	}

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroBairroDTO dados, UriComponentsBuilder uriBuilder) {
		var dto = service.gravar(dados);
		var rua = repository.getReferenceById(dto.id());
		var uri = uriBuilder.path("/bairro/{id}").buildAndExpand(rua.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
		//return ResponseEntity.ok(dto);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoBairroDTO dados, UriComponentsBuilder uriBuilder) {
		var dto = service.atualizarInformacoes(dados);
		var rua = repository.getReferenceById(dto.id());
		var uri = uriBuilder.path("/bairro/{id}").buildAndExpand(rua.getId()).toUri();

		return ResponseEntity.ok(dto);
	}
	
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
    	repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemBairroDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemBairroDTO::new);
        return ResponseEntity.ok(page);
    }
	

}
