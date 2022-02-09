package com.finacapi.financapi.resource;

import com.finacapi.financapi.event.RecursoEvent;
import com.finacapi.financapi.model.Pessoa;
import com.finacapi.financapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

        @Autowired
        private PessoaRepository pessoaRepository;

        @GetMapping
        public List<Pessoa> listar(){
            return pessoaRepository.findAll();
        }

        @Autowired
        private ApplicationEventPublisher publisher;

        @PostMapping
        public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
            Pessoa pessoaaSalva = pessoaRepository.save(pessoa);
            publisher.publishEvent(new RecursoEvent(this,response,pessoaaSalva.getCodigo()));
            return (ResponseEntity<Pessoa>) ResponseEntity.status(HttpStatus.CREATED).body(pessoaaSalva);
        }
        @GetMapping("/{codigo}")
        public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo){
            Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);

            return pessoa.isPresent() ? ResponseEntity.ok(pessoa.get()) : ResponseEntity.notFound().build();
        }
    }
