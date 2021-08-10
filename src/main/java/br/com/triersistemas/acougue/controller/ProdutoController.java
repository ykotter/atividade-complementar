package br.com.triersistemas.acougue.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.acougue.armezenamento.SalvaDados;
import br.com.triersistemas.acougue.model.EnumTipoProdutoModel;
import br.com.triersistemas.acougue.model.ProdutoModel;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@GetMapping("/cadastrar")
	public ProdutoModel CadastrarProduto(@RequestParam String nome,
										 @RequestParam BigDecimal valor,
										 @RequestParam EnumTipoProdutoModel tipo) {
		ProdutoModel p = new ProdutoModel(nome, valor, tipo);
		SalvaDados.produtos.add(p);
		return p;
	}
	
	@GetMapping("/alterar")
	public ProdutoModel AlterarProduto(@RequestParam Long id,
			                           @RequestParam String nome,
									   @RequestParam BigDecimal valor,
									   @RequestParam EnumTipoProdutoModel tipo) {
		for (ProdutoModel p : SalvaDados.produtos) {
			if (id.equals(p.getId())); {
				p.alterar(nome, valor, tipo);
				return p;
			}
		}
		return null;
	} 
	
	@GetMapping("/excluir")
	public ProdutoModel ExcluirProduto(@RequestParam Long id) {
		for (ProdutoModel p : SalvaDados.produtos) {
			if (id.equals(p.getId())); {
				SalvaDados.produtos.remove(p);
				return p;
			}
		}
		return null;
	} 
	
	@GetMapping("/listar")
	public List<ProdutoModel> ListarProduto() {
		return SalvaDados.produtos;
	}
}
