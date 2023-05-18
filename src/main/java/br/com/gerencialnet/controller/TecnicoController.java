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

import br.com.gerencialnet.domain.tecnico.AtualizacaoTecnicoDTO;
import br.com.gerencialnet.domain.tecnico.CadastroTecnicoDTO;
import br.com.gerencialnet.domain.tecnico.DetalhamentoTecnicoDTO;
import br.com.gerencialnet.domain.tecnico.ListagemTecnicoDTO;
import br.com.gerencialnet.domain.tecnico.Tecnico;
import br.com.gerencialnet.domain.tecnico.TecnicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RequestMapping("/tecnico")
@RestController
@SecurityRequirement(name = "bearer-key")
public class TecnicoController {
	
	@Autowired
	private TecnicoRepository repository;
	
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroTecnicoDTO dados, UriComponentsBuilder uriBuilder) {
    	var tecnico = new Tecnico(dados);
    	repository.save(tecnico);
    	
    	var uri = uriBuilder.path("/tecnico/{id}").buildAndExpand(tecnico.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DetalhamentoTecnicoDTO(tecnico));
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemTecnicoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemTecnicoDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoTecnicoDTO dados){
        var tecnico = repository.getReferenceById(dados.id());

        tecnico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoTecnicoDTO(tecnico));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var tecnico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoTecnicoDTO(tecnico));
    }
	

}
