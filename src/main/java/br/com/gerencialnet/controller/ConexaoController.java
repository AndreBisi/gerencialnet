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
import br.com.gerencialnet.domain.cidade.DetalhamentoCidadeDTO;
import br.com.gerencialnet.domain.cidade.ListagemCidadeDTO;
import br.com.gerencialnet.domain.conexao.AtualizacaoConexaoDTO;
import br.com.gerencialnet.domain.conexao.CadastroConexaoDTO;
import br.com.gerencialnet.domain.conexao.Conexao;
import br.com.gerencialnet.domain.conexao.ConexaoRepository;
import br.com.gerencialnet.domain.conexao.DetalhamentoConexaoDTO;
import br.com.gerencialnet.domain.conexao.ListagemConexaoDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/conexao")			
@SecurityRequirement(name = "bearer-key")
public class ConexaoController {
	
	@Autowired
	private ConexaoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CadastroConexaoDTO dados, UriComponentsBuilder uriBuilder) {
		var conexao = new Conexao(dados);
		repository.save(conexao);
		var uri = uriBuilder.path("/conexao/{id}").buildAndExpand(conexao.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhamentoConexaoDTO(conexao));
	}

	@GetMapping
	public ResponseEntity<Page<ListagemConexaoDTO>> listar(
			@PageableDefault(size = 10, sort = { "id" }) Pageable paginacao) {
		// @PageableDefault(size = 10, sort = {"nome"})
		// o size padrão é 20
		// sort não tem padrão

		var page = repository.findAll(paginacao).map(ListagemConexaoDTO::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoConexaoDTO dados) {
		var conexao = repository.getReferenceById(dados.id());

		conexao.atualizaInformacoes(dados);

		return ResponseEntity.ok(new DetalhamentoConexaoDTO(conexao));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		var conexao = repository.getReferenceById(id);

		return ResponseEntity.ok(new DetalhamentoConexaoDTO(conexao));
	}

	

}
