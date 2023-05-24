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

import br.com.gerencialnet.domain.pessoa.AtualizacaoPessoaDTO;
import br.com.gerencialnet.domain.pessoa.CadastroPessoaDTO;
import br.com.gerencialnet.domain.pessoa.DetalhamentoPessoaDTO;
import br.com.gerencialnet.domain.pessoa.ListagemPessoaDTO;
import br.com.gerencialnet.domain.pessoa.Pessoa;
import br.com.gerencialnet.domain.pessoa.PessoaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

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
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroPessoaDTO dados, UriComponentsBuilder uriBuilder) {
    	var pessoa = new Pessoa(dados);
    	repository.save(pessoa);
    	
    	var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DetalhamentoPessoaDTO(pessoa));
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemPessoaDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemPessoaDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoPessoaDTO dados){
        var pessoa = repository.getReferenceById(dados.id());

        pessoa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoPessoaDTO(pessoa));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
