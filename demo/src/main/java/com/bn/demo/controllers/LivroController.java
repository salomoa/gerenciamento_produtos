package com.bn.demo.controllers;

import com.bn.demo.models.LivroModel;
import com.bn.demo.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/livros", "/livros/"})
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
        public ResponseEntity<List<LivroModel> > findAll(){
          List<LivroModel> requeste = livroService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <LivroModel> criarPessoa(@RequestBody LivroModel livroModel){
        LivroModel requeste = livroService.criarPessoa(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livroModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarId(@PathVariable Long id){
        return  livroService.buscarid(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <LivroModel> atualizar(@PathVariable Long id, @RequestBody LivroModel LivroModel){
        LivroModel requeste = livroService.atualizar(id, LivroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(LivroModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);

    }








}
