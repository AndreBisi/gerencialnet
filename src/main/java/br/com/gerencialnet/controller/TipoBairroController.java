package br.com.gerencialnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gerencialnet.domain.logradouro.CadastroLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.ListagemLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;
import br.com.gerencialnet.domain.tipoBairro.AtualizacaoTipoBairroDTO;
import br.com.gerencialnet.domain.tipoBairro.CadastroTipoBairroDTO;
import br.com.gerencialnet.domain.tipoBairro.DetalhamentoTipoBairroDTO;
import br.com.gerencialnet.domain.tipoBairro.ListagemTipoBairroDTO;
import br.com.gerencialnet.domain.tipoBairro.TipoBairro;
import br.com.gerencialnet.domain.tipoBairro.TipoBairroRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipobairro")
@SecurityRequirement(name = "bearer-key")
public class TipoBairroController {
	
	@Autowired
	private TipoBairroRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroTipoBairroDTO dados, UriComponentsBuilder uriBuilder) {
        var tipoBairro = new TipoBairro(dados);
        repository.save(tipoBairro);
        
        var uri = uriBuilder.path("/tipobairro/{id}").buildAndExpand(tipoBairro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoTipoBairroDTO(tipoBairro));
		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoTipoBairroDTO dados, UriComponentsBuilder uriBuilder) {
		
		var tipoBairro = repository.getReferenceById(dados.id());
		
		tipoBairro.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DetalhamentoTipoBairroDTO(tipoBairro));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		var tipoBairro = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DetalhamentoTipoBairroDTO(tipoBairro));
	}
	
    @GetMapping
    public ResponseEntity<Page<ListagemTipoBairroDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemTipoBairroDTO::new);
        return ResponseEntity.ok(page);
    }

}
