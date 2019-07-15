package com.sempreNavegando.menuCardapio.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sempreNavegando.menuCardapio.demo.DTO.PedidoDto;
import com.sempreNavegando.menuCardapio.demo.model.Pedido;
import com.sempreNavegando.menuCardapio.demo.model.Produto;
import com.sempreNavegando.menuCardapio.demo.repository.PedidoRepository;
import com.sempreNavegando.menuCardapio.demo.repository.ProdutoRepository;

@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	
    @Autowired
    public  PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository){
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }
    
    private static final String aberto = "EMABERTO";
    private static final String fechado = "FINALIZADO";
    
    public void criarPedido(PedidoDto pedidoDto) {
    	Produto produto = produtoRepository.findByNomProduto(pedidoDto.getNomeProduto());
    	
    	Pedido pedido = new Pedido();
    	
    	pedido.setNumMesa(pedidoDto.getMesa());
    	pedido.setProduto(produto);
    	pedido.setQuantidade_produto(pedidoDto.getQtd_produto());
    	pedido.setSituacaoPedido(aberto);
    	
    	pedidoRepository.save(pedido);
    }
    
    public List<PedidoDto> retornarListaDePedidos(){
    	List<Pedido> pedidoList =  pedidoRepository.findBySituacaoPedido(aberto);
    	
    	List<PedidoDto> retornoList = new ArrayList<>();
    	
    	if(pedidoList.size() > 0) {
	    	for(Pedido pedido : pedidoList) {
	    		retornoList.add(new PedidoDto(pedido));
	    	}
	    	
	    	return retornoList;
    	}else {
    		System.out.println("Fila 0.");
    		return retornoList;
    	}
    }
    
    public void finalizarPedido(Long id) {
    	Pedido pedido = pedidoRepository.findOneById(id);
    	pedido.setSituacaoPedido(fechado);
    	
    	pedidoRepository.save(pedido);
    }
}
