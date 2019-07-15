package com.sempreNavegando.menuCardapio.demo.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sempreNavegando.menuCardapio.demo.service.ProdutoService;

@Controller
@RequestMapping("/api/produto")
public class ProdutoControle {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("")
    public ResponseEntity<?> getAllCitys(){
        return new ResponseEntity<>(produtoService.getCardapio(), HttpStatus.OK);
    }
}
