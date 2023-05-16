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

import br.com.gerencialnet.domain.banco.AtualizacaoBancoDTO;
import br.com.gerencialnet.domain.banco.Banco;
import br.com.gerencialnet.domain.banco.BancoRepository;
import br.com.gerencialnet.domain.banco.CadastroBancoDTO;
import br.com.gerencialnet.domain.banco.DetalhamentoBancoDTO;
import br.com.gerencialnet.domain.banco.ListagemBancoDTO;
import br.com.gerencialnet.domain.servico.AtualizacaoServicoDTO;
import br.com.gerencialnet.domain.servico.CadastroServicoDTO;
import br.com.gerencialnet.domain.servico.DetalhamentoServicoDTO;
import br.com.gerencialnet.domain.servico.ListagemServicoDTO;
import br.com.gerencialnet.domain.servico.Servico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/banco")
@SecurityRequirement(name = "bearer-key")
public class BancoController {
	
	@Autowired
	private BancoRepository repository;
	
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroBancoDTO dados, UriComponentsBuilder uriBuilder) {
    	var banco = new Banco(dados);
    	repository.save(banco);
    	
    	var uri = uriBuilder.path("/banco/{id}").buildAndExpand(banco.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DetalhamentoBancoDTO(banco));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoBancoDTO dados){
        var banco = repository.getReferenceById(dados.id());

        banco.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoBancoDTO(banco));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var banco = repository.getReferenceById(id);
        
       	return ResponseEntity.ok(new DetalhamentoBancoDTO(banco));        	
    }

    @GetMapping
    public ResponseEntity<Page<ListagemBancoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemBancoDTO::new);
        return ResponseEntity.ok(page);
    }
    
}
