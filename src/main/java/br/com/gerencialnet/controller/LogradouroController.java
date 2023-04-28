package br.com.gerencialnet.controller;

import br.com.gerencialnet.domain.logradouro.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/logradouro")
@SecurityRequirement(name = "bearer-key")
public class LogradouroController {

    @Autowired
    private LogradouroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroLogradouroDTO dados, UriComponentsBuilder uriBuilder){
        var logradouro = new Logradouro(dados);
        repository.save(logradouro);
        var uri = uriBuilder.path("/logradouro/{id}").buildAndExpand(logradouro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoLogradouroDTO(logradouro));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemLogradouroDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //@PageableDefault(size = 10, sort = {"nome"})
        //o size padrão é 20
        //sort não tem padrão

        var page = repository.findAll(paginacao).map(ListagemLogradouroDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoLogradouroDTO dados){
        var logradouro = repository.getReferenceById(dados.id());

        logradouro.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoLogradouroDTO(logradouro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var logradouro = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoLogradouroDTO(logradouro));
    }

}
