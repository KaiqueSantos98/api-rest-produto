package com.sempreNavegando.menuCardapio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sempreNavegando.menuCardapio.demo.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Produto findByNomProduto (String nome);
}
