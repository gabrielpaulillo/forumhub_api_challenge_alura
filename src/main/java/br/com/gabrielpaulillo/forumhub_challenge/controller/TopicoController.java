package br.com.gabrielpaulillo.forumhub_challenge.controller;

import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosDetalhamentoTopico;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosTopico;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.Topico;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.TopicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@Tag(name = "Tópicos - Necessita autenticar")
public class TopicoController {

    @Autowired
    TopicoService service;

    @PostMapping
    @Transactional
    @Operation(summary = "Criar", description = "Cria nova tópico")
    public ResponseEntity criar(@RequestBody @Valid DadosTopico dados, UriComponentsBuilder uriBuilder){

        var topicoSalvo = service.criar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicoSalvo));
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos tópicos")
    public ResponseEntity<List<Topico>> listar(){
        var todos = service.listar();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar", description = "Lista tópico com determinado id")
    public ResponseEntity<Topico> listar(@PathVariable Long id){
        Optional<Topico> topicoOptional = service.detalhar(id);

        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();
            return ResponseEntity.ok(topico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualizar", description = "Atualizar tópico com determinado id")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosTopico dados) {
        Topico topicoAtualizado = service.atualizar(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Apagar", description = "Apaga tópico com determinado id")
    public ResponseEntity<Topico> apagar(@PathVariable Long id) {
        service.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
