package br.com.triersistemas.acougue.model;

import java.math.BigDecimal;

public class ItemCarrinhoModel {
	
	private static long count = 0;
	
	private BigDecimal qtdKg;
	private ProdutoModel produto;
	private Long id;
	
	public ItemCarrinhoModel(BigDecimal qtdKg, ProdutoModel produto) {
		this.qtdKg = qtdKg;
		this.produto = produto;
		this.id = ++count;
	}

	public BigDecimal getQtdKg() {
		return qtdKg;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public Long getId() {
		return id;
	}
	
	public BigDecimal getValorTotal() {
		return produto.getValorKg().multiply(this.qtdKg);
	}
}
