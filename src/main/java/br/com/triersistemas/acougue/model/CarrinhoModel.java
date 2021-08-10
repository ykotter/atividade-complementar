package br.com.triersistemas.acougue.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
	
	private static long count = 0;
	
	private EnumStatusCarrinhoModel status;
	private LocalDateTime dataCarrinho;
	private LocalDateTime dataPagamento;
	private List<ItemCarrinhoModel> carnes;
	private Long id;
	
	public CarrinhoModel() {
		this.id = ++count;
		this.status = EnumStatusCarrinhoModel.AGUARDANDO;
		this.dataCarrinho = LocalDateTime.now();
		this.carnes = new ArrayList<>();
	}
	
	public void addCarne(ProdutoModel p, BigDecimal qtd) {
		if (!status.equals(EnumStatusCarrinhoModel.PAGO)) {
			this.carnes.add(new ItemCarrinhoModel(qtd, p));
		} else {
			throw new RuntimeException ("Errouu!!");
		}
	}

	public EnumStatusCarrinhoModel getStatus() {
		return status;
	}

	public LocalDateTime getDataCarrinho() {
		return dataCarrinho;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public List<ItemCarrinhoModel> getCarnes() {
		return carnes;
	}

	public Long getId() {
		return id;
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCarrinhoModel i : carnes) {
			soma = soma.add(i.getValorTotal());
		} 
		return soma;
	}
	
	public EnumStatusCarrinhoModel pagar() {
		this.dataPagamento = LocalDateTime.now();
		this.status = EnumStatusCarrinhoModel.PAGO;
		return status;
	}
}
