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

import br.com.gerencialnet.domain.rua.AtualizacaoRuaDTO;
import br.com.gerencialnet.domain.rua.CadastroRuaDTO;
import br.com.gerencialnet.domain.rua.DetalhamentoRuaDTO;
import br.com.gerencialnet.domain.rua.ListagemRuaDTO;
import br.com.gerencialnet.domain.rua.RuaRepository;
import br.com.gerencialnet.domain.rua.RuaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rua")
@SecurityRequirement(name = "bearer-key")
public class RuaController {

	@Autowired
	private RuaRepository ruaRepository;

	@Autowired
	private RuaService ruaService;

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {

		var rua = ruaRepository.getReferenceById(id);

		return ResponseEntity.ok(new DetalhamentoRuaDTO(rua));
	}

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroRuaDTO dados, UriComponentsBuilder uriBuilder) {
		var dto = ruaService.gravar(dados);
		var rua = ruaRepository.getReferenceById(dto.id());
		var uri = uriBuilder.path("/rua/{id}").buildAndExpand(rua.getId()).toUri();

		// return ResponseEntity.created(uri).body(dto);
		return ResponseEntity.ok(dto);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoRuaDTO dados, UriComponentsBuilder uriBuilder) {
		var dto = ruaService.atualizarInformacoes(dados);
		var rua = ruaRepository.getReferenceById(dto.id());
		var uri = uriBuilder.path("/rua/{id}").buildAndExpand(rua.getId()).toUri();

		return ResponseEntity.ok(dto);
	}
	
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
    	ruaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<Page<ListagemRuaDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = ruaRepository.findAll(paginacao).map(ListagemRuaDTO::new);
        return ResponseEntity.ok(page);
    }
}
