package com.sempreNavegando.menuCardapio.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Pedido")
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NUMERO_MESA")
	@NotNull(message = "Campo número da mesa não informado, favor verificar!")
	private Integer numMesa;
	
	@Column(name = "SITUACAO_PEDIDO")
	private String situacaoPedido;
	
	@NotNull(message = "Campo obrigatório! Quantidade de produtos deve ser preenchida.")
	@Column(name = "QTD_PRODUTO")
	private  int quantidade_produto;
	
	@OneToOne
    private Produto produto;
}
