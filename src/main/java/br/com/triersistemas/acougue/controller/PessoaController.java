package br.com.triersistemas.acougue.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.acougue.armezenamento.SalvaDados;
import br.com.triersistemas.acougue.model.AcougueiroModel;
import br.com.triersistemas.acougue.model.ClienteModel;
import br.com.triersistemas.acougue.model.PessoaModel;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@GetMapping("/cadastrar-acougueiro")
	public PessoaModel CadastrarAcougueiro(@RequestParam String nome,
										   @RequestParam String documento) {
		PessoaModel p = new AcougueiroModel(nome, documento);
		SalvaDados.pessoas.add(p);
		return p;
	}
	
	@GetMapping("/cadastrar-cliente")
	public PessoaModel CadastrarCliente(@RequestParam String nome,
										   @RequestParam String documento,
										   @RequestParam String estado) {
		PessoaModel p = new ClienteModel(nome, documento, estado);
		SalvaDados.pessoas.add(p);
		return p;
	}
	
	@GetMapping("/excluir")
	public PessoaModel ExcluirPessoa(@RequestParam Long id) {
		for (PessoaModel p : SalvaDados.pessoas) {
			if (id.equals(p.getId())) {
				SalvaDados.pessoas.remove(p);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<PessoaModel> ListarPessoas() {
		return SalvaDados.pessoas;
	}
	
	@GetMapping("/validar")
	public String ValidarDocumento(@RequestParam Long id) {
		for (PessoaModel p : SalvaDados.pessoas) {
			if (id.equals(p.getId())) {
				if (p.isCpfValido()) {
					String cpf = p.getDocumento();
					cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
					return cpf;
				}
			}
		}
		return "Documento Inválido";
	}

}
