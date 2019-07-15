package com.sempreNavegando.menuCardapio.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sempreNavegando.menuCardapio.demo.model.Pedido;
import com.sempreNavegando.menuCardapio.demo.model.Produto;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	List<Pedido> findBySituacaoPedido(String situacaoPedido);
	
	Pedido findOneById(Long id);
}
