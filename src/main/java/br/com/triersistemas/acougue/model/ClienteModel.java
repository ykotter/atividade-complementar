package br.com.triersistemas.acougue.model;

import java.util.Objects;

public class ClienteModel extends PessoaModel{
	
	private static long count = 0;
	
	private Long id;
	private String estado;
	
	public ClienteModel( String nome,String documento, String estado) {
		super(nome, documento);
		this.id = ++count;
		this.estado = estado;
	}

	@Override
	public Boolean isCpfValido() {
		if (Objects.isNull(super.getDocumento())
				|| super.getDocumento().length() != 11) {
			return false;
		}
		Integer digitoEstado = null;
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
		if (this.estado.equalsIgnoreCase("Rio Grande do Sul")) {
			digitoEstado = 0;
		}
		if (this.estado.equalsIgnoreCase("DistritoFederal") || this.estado.equalsIgnoreCase("Goiás") || this.estado.equalsIgnoreCase("MatoGrosso") 
				|| this.estado.equalsIgnoreCase("MatoGrossodoSul") || this.estado.equalsIgnoreCase("Tocantins")) {
			digitoEstado = 1;
		}
		if (this.estado.equalsIgnoreCase("Amazonas") || this.estado.equalsIgnoreCase("Para") || this.estado.equalsIgnoreCase("Roraima") 
				|| this.estado.equalsIgnoreCase("Amapa") || this.estado.equalsIgnoreCase("Acre") || this.estado.equalsIgnoreCase("Rondonia")) {
			digitoEstado = 2;
		}
		if (this.estado.equalsIgnoreCase("Ceara") || this.estado.equalsIgnoreCase("Maranhao") || this.estado.equalsIgnoreCase("Piaui")) {
			digitoEstado = 3;
		}
		if (this.estado.equalsIgnoreCase("Paraiba") || this.estado.equalsIgnoreCase("Pernambuco") || this.estado.equalsIgnoreCase("Alagoas") 
				|| this.estado.equalsIgnoreCase("RioGrandedoNorte")) {
			digitoEstado = 4;
		}
		if (this.estado.equalsIgnoreCase("Bahia") || this.estado.equalsIgnoreCase("Sergipe")) {
			digitoEstado = 5;
		}
		if (this.estado.equalsIgnoreCase("MinasGerais")) {
			digitoEstado = 6;
		}
		if (this.estado.equalsIgnoreCase("RiodeJaneiro") || this.estado.equalsIgnoreCase("EspiritoSanto")) {
			digitoEstado = 7;
		}
		if (this.estado.equalsIgnoreCase("SaoPaulo")) {
			digitoEstado = 8;
		}
		if (this.estado.equalsIgnoreCase("Parana") || this.estado.equalsIgnoreCase("SantaCatarina")) {
			digitoEstado = 9;
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[9])) && segundoVerificador.equals(Integer.parseInt(arrayString[10])) 
				&& digitoEstado.equals(Integer.parseInt(arrayString[8]))) {
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}
}
