package br.com.triersistemas.acougue.model;

public abstract class PessoaModel {
	
	private static long count = 0;
	
	private String documento;
	private String nome;
	private Long id;
	
	public PessoaModel(String nome,String documento) {
		this.documento = documento;
		this.nome = nome;
		this.id = ++count;
	}
	
	public abstract Boolean isCpfValido();
	
	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}	
}
