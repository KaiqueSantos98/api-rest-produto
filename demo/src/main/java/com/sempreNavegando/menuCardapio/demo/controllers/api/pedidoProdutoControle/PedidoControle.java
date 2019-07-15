package com.sempreNavegando.menuCardapio.demo.controllers.api.pedidoProdutoControle;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sempreNavegando.menuCardapio.demo.DTO.PedidoDto;
import com.sempreNavegando.menuCardapio.demo.model.Pedido;
import com.sempreNavegando.menuCardapio.demo.repository.PedidoRepository;
import com.sempreNavegando.menuCardapio.demo.service.PedidoService;
import com.sempreNavegando.menuCardapio.demo.service.ProdutoService;

@Controller
@RequestMapping("/api/pedidoProduto")
public class PedidoControle {
    @Autowired
    PedidoService pedidoService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void criarPedido(@Valid @RequestBody PedidoDto pedidoDto){
        pedidoService.criarPedido(pedidoDto);
    }
    
    @GetMapping("/buscarPedido")
    @Size(min = 1)
    public ResponseEntity<?> retornaPedido() {
    	return new ResponseEntity<>(pedidoService.retornarListaDePedidos(), HttpStatus.OK);
    }
    
    @PutMapping("/finalizarPedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void finalizarPedido(@PathVariable Long id){
    	pedidoService.finalizarPedido(id);
    }
}
