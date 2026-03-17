package com.bn.demo.services;

import com.bn.demo.models.LivroModel;
import com.bn.demo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll(){
        return  livroRepository.findAll();
    }

    public LivroModel criarPessoa(LivroModel livroModel){
        return  livroRepository.save(livroModel);
    }

    public Optional<LivroModel> buscarid(Long id){
        return  livroRepository.findById(id);
    }

    public LivroModel atualizar(Long id, LivroModel livroModel){
        LivroModel model = livroRepository.findById(id).get();
        model.setAutor(livroModel.getAutor());
        model.setAnoPublicacao(livroModel.getAnoPublicacao());
        model.setTitulo(livroModel.getTitulo());
        return livroRepository.save(model);
    }

    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

}
