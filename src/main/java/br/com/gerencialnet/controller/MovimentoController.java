package br.com.gerencialnet.controller;

import br.com.gerencialnet.domain.movimento.*;
import br.com.gerencialnet.domain.movimento.validacoes.cadastro.ValidadorCadastroMovimento;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/movimento")
@SecurityRequirement(name = "bearer-key")
public class MovimentoController {
	
	@Autowired
	private MovimentoRepository repository;
	
    @Autowired
    private List<ValidadorCadastroMovimento> validadores;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroMovimentoDTO dados, UriComponentsBuilder uriBuilder) {
		var movimento = new Movimento(dados);
		
		validadores.forEach(v -> v.validar(dados));
		
		repository.save(movimento);
		
		var uri = uriBuilder.path("/movimento/{id}").buildAndExpand(movimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhamentoMovimentoDTO(movimento));
	}
	
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var movimento = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoMovimentoDTO(movimento));
    }
    
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemMovimentoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemMovimentoDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoMovimentoDTO dados) {
		var movimento = repository.getReferenceById(dados.id());
		
		//validadores.forEach(v -> v.validar(dados));

		movimento.atualizarInformacoes(dados);

		return ResponseEntity.ok(new DetalhamentoMovimentoDTO(movimento));
	}

}
