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

import br.com.gerencialnet.domain.vendedor.AtualizacaoVendedorDTO;
import br.com.gerencialnet.domain.vendedor.CadastroVendedorDTO;
import br.com.gerencialnet.domain.vendedor.DetalhamentoVendedorDTO;
import br.com.gerencialnet.domain.vendedor.ListagemVendedorDTO;
import br.com.gerencialnet.domain.vendedor.Vendedor;
import br.com.gerencialnet.domain.vendedor.VendedorRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedor")
@SecurityRequirement(name = "bearer-key")
public class VendedorController {

	@Autowired
	private VendedorRepository repository;
	
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroVendedorDTO dados, UriComponentsBuilder uriBuilder) {
    	var vendedor = new Vendedor(dados);
    	repository.save(vendedor);
    	
    	var uri = uriBuilder.path("/vendedor/{id}").buildAndExpand(vendedor.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DetalhamentoVendedorDTO(vendedor));
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemVendedorDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemVendedorDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoVendedorDTO dados){
        var vendedor = repository.getReferenceById(dados.id());

        vendedor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoVendedorDTO(vendedor));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var vendedor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoVendedorDTO(vendedor));
    }
	
	
}
