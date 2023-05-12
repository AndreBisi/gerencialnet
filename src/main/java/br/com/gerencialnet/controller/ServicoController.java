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

import br.com.gerencialnet.domain.logradouro.AtualizacaoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.ListagemLogradouroDTO;
import br.com.gerencialnet.domain.servico.AtualizacaoServicoDTO;
import br.com.gerencialnet.domain.servico.CadastroServicoDTO;
import br.com.gerencialnet.domain.servico.DetalhamentoServicoDTO;
import br.com.gerencialnet.domain.servico.ListagemServicoDTO;
import br.com.gerencialnet.domain.servico.Servico;
import br.com.gerencialnet.domain.servico.ServicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servico")
@SecurityRequirement(name = "bearer-key")
public class ServicoController {
	
	@Autowired
	private ServicoRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroServicoDTO dados, UriComponentsBuilder uriBuilder) {
    	var servico = new Servico(dados);
    	repository.save(servico);
    	
    	var uri = uriBuilder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DetalhamentoServicoDTO(servico));
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemServicoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemServicoDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoServicoDTO dados){
        var servico = repository.getReferenceById(dados.id());

        servico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoServicoDTO(servico));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var servico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoServicoDTO(servico));
    }

}
