package br.com.triersistemas.acougue.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.acougue.armezenamento.SalvaDados;
import br.com.triersistemas.acougue.model.CarrinhoModel;
import br.com.triersistemas.acougue.model.EnumStatusCarrinhoModel;
import br.com.triersistemas.acougue.model.ProdutoModel;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@GetMapping("/cadastrar")
	public CarrinhoModel CadastrarCarrinho() {
		CarrinhoModel c = new CarrinhoModel();
		SalvaDados.carrinhos.add(c);
		return c;
	}
	
	@GetMapping("/adicionar")
	public CarrinhoModel AdicionarCarrinho(@RequestParam(value = "id-carrinho") Long idCa,
			                               @RequestParam(value = "id-produto") Long idPr,
			                               @RequestParam(value = "quantidade") BigDecimal qtd) {
		ProdutoModel p = null;
		for (ProdutoModel pr : SalvaDados.produtos) {
			if (idPr.equals(pr.getId())) {
				p = pr;
			}
		}
		for (CarrinhoModel c : SalvaDados.carrinhos) {
			if (idCa.equals(c.getId())) {
				c.addCarne(p, qtd);
				return c;
			}
		}
		return null;
	}
	
	@GetMapping("/pagar")
	public CarrinhoModel pagar(@RequestParam Long id) {
		for (CarrinhoModel c : SalvaDados.carrinhos) {
			if (id.equals(c.getId())) {
				c.pagar();
				return c;
			}
		}
		return null;
	}
	
	@GetMapping("/excluir")
	public CarrinhoModel excluir(@RequestParam Long id) {
		for (CarrinhoModel c : SalvaDados.carrinhos) {
			if (id.equals(c.getId())) {
				if (c.getStatus().equals(EnumStatusCarrinhoModel.AGUARDANDO)) {
					SalvaDados.carrinhos.remove(c);
					return c;
				}
			}
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<CarrinhoModel> listar() {
		return SalvaDados.carrinhos;
	}
}
