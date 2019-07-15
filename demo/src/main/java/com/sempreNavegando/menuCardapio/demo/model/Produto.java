package com.sempreNavegando.menuCardapio.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Produto")
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME")
	@NotNull(message = "Produto não informado, favor verificar!")
	@Size(min = 3, max = 20)
	private String nomProduto;
	
	@Column(name = "PRECO")
	@NotNull(message = "Campo obrigatório! Preço do produtos deve ser informado, favor verificar!.")
	private double precoProduto;
	
	@Column(name = "DESCRICAO")
	@Size(min = 10, max = 99)
	private String descricaoProduto;	
}
