package com.bn.demo.controllers;

import com.bn.demo.models.ProdutoModel;
import com.bn.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/produtos", "/produtos/"})
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
        public ResponseEntity<List<ProdutoModel> > findAll(){
          List<ProdutoModel> requeste = produtoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <ProdutoModel> criarPessoa(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarPessoa(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produtoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarId(@PathVariable Long id){
        return  produtoService.buscarid(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel ProdutoModel){
        ProdutoModel requeste = produtoService.atualizar(id, ProdutoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(ProdutoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);

    }








}
