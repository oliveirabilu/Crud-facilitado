package com.examplecrud.crud.controllers;

import com.examplecrud.crud.entities.Pessoa;
import com.examplecrud.crud.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarPessoa(){
        return ResponseEntity.ok(pessoaService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarporId(@PathVariable Long id){
        var pessoa=pessoaService.buscarporId(id);
        return pessoa != null ? ResponseEntity.ok() : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa){
        return ResponseEntity.ok().body(pessoa);
    }
}
