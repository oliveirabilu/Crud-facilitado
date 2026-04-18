package com.examplecrud.crud.services;

import com.examplecrud.crud.entities.Pessoa;
import com.examplecrud.crud.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa buscarporId(Long id){
       Optional<Pessoa> optionalPessoa= pessoaRepository.findById(id);
        return optionalPessoa.orElse(null);
    }
    @Transactional
    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    @Transactional
    public void atualizar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }
    public void deletar(Long id){
        pessoaRepository.deleteById(id);
    }
}
