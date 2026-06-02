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

@RestController // Declara que o controlador sera usado com REST
@RequestMapping(path = {"/produtos", "/produtos/"}) // Declara o caminho para a url que sera utilizada
public class ProdutoController {

    @Autowired // adicionar dependencias automaticamente
    private ProdutoService produtoService;

    @GetMapping // Mapeamento do metodo get para o metedo de busca
        public ResponseEntity<List<ProdutoModel> > buscarTodosOsProdutos(){
          List<ProdutoModel> requeste = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping // mapeamento do metodo post para o metodo de criacao
    public ResponseEntity <ProdutoModel> criarProdutos(@RequestBody ProdutoModel produtoModel){ // request body e a declaracao da estrutura da classe chamada
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produtoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}") // mapeamento do metodo delete para o metodo de exclusao
    public ResponseEntity<?> deletarProdutos(@PathVariable Long id){ // Path variable e a declaracao de qual coluna devera ser usada para o metodo
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}") // Mapeamento do metodo get para o metedo de busca
    public Optional<ProdutoModel> buscarProdutoPorId(@PathVariable Long id){ // Path variable e a declaracao de qual coluna devera ser usada para o metodo
        return  produtoService.buscarProdutoId(id);
    }

    @PutMapping("/{id}") // mapeamento do metodo put para o metodo de atualizacao
    public ResponseEntity <ProdutoModel> atualizarProdutos(@PathVariable Long id, @RequestBody ProdutoModel ProdutoModel){ // request body e a declaracao da estrutura da classe chamada; Path variable e a declaracao de qual coluna devera ser usada para o metodo
        ProdutoModel requeste = produtoService.atualizarProduto(id, ProdutoModel);
        return  ResponseEntity.ok().body(requeste);

    }








}
