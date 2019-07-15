package com.sempreNavegando.menuCardapio.demo.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sempreNavegando.menuCardapio.demo.model.Pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {
	private Long id;
	@NotNull(message = "Campo obrigatório, nome produto.")
	private String nomeProduto;
	
	@NotNull(message = "Campo obrigatório, quantidade produto.")
	private int qtd_produto;
	
	@NotNull(message = "Campo obrigatório, número da mesa produto.")
	private int mesa;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.nomeProduto = pedido.getProduto().getNomProduto();
		this.qtd_produto = pedido.getQuantidade_produto();
		this.mesa = pedido.getNumMesa();
	}
	
	public PedidoDto() {
		
	}
	
}
