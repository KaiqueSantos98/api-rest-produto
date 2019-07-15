package com.sempreNavegando.menuCardapio.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sempreNavegando.menuCardapio.demo.model.Produto;
import com.sempreNavegando.menuCardapio.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	
    @Autowired
    public  ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    
    public List<Produto> getCardapio() {
    	return produtoRepository.findAll();
    }
}

