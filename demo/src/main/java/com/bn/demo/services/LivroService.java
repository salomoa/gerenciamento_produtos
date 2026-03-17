package com.bn.demo.services;

import com.bn.demo.models.ProdutoModel;
import com.bn.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<ProdutoModel> findAll(){
        return  livroRepository.findAll();
    }

    public ProdutoModel criarPessoa(ProdutoModel produtoModel){
        return  livroRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarid(Long id){
        return  livroRepository.findById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = livroRepository.findById(id).get();
        model.setPreco(produtoModel.getPreco());
        model.setEstoque(produtoModel.getEstoque());
        model.setNome(produtoModel.getNome());
        return livroRepository.save(model);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
