package br.com.triersistemas.acougue.model;

import java.math.BigDecimal;

public class ProdutoModel {
	
	private static long count = 0;
	
	private String nome;
	private BigDecimal valorKg;
	private EnumTipoProdutoModel tipo;
	private Long id;
	
	public ProdutoModel(String nome, BigDecimal valorKg, EnumTipoProdutoModel tipo) {
		this.nome = nome;
		this.valorKg = valorKg;
		this.tipo = tipo;
		this.id = ++count;
	}
	
	public void alterar(String nome, BigDecimal valorKg, EnumTipoProdutoModel tipo) {
		this.nome = nome;
		this.valorKg = valorKg;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValorKg() {
		return valorKg;
	}

	public EnumTipoProdutoModel getTipo() {
		return tipo;
	}

	public Long getId() {
		return id;
	}
}
