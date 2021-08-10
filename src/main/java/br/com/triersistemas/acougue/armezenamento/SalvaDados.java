package br.com.triersistemas.acougue.armezenamento;

import java.util.ArrayList;
import java.util.List;

import br.com.triersistemas.acougue.model.CarrinhoModel;
import br.com.triersistemas.acougue.model.PessoaModel;
import br.com.triersistemas.acougue.model.ProdutoModel;

public class SalvaDados {
	
private SalvaDados() {}
	
	public static List<ProdutoModel> produtos = new ArrayList<>();
	public static List<PessoaModel> pessoas = new ArrayList<>();
	public static List<CarrinhoModel> carrinhos = new ArrayList<>();
}
