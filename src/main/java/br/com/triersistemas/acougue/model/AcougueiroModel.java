package br.com.triersistemas.acougue.model;

import java.util.Objects;

public class AcougueiroModel extends PessoaModel {
	
	private static long count = 0;
	
	private Long id;
	
	public AcougueiroModel(String nome, String documento) {
		super(nome, documento);
		this.id = ++count;
	}

	@Override
	public Boolean isCpfValido() {
		if (Objects.isNull(super.getDocumento())
				|| super.getDocumento().length() != 11) {
			return false;
		}
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer j = 1;
		char[] arrayDoc = super.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];

		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
		}
		primeiroVerificador = soma % 11;
		if (primeiroVerificador == 10) {
			primeiroVerificador = 0;
		}
		j = 0;
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
		}
		segundoVerificador = somaSegundo % 11;
		if (segundoVerificador == 10) {
			segundoVerificador = 0;
		}

		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[9])) && segundoVerificador.equals(Integer.parseInt(arrayString[10]))) {
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}
}
