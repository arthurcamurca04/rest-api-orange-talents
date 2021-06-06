package com.orangetalents.desafio.restapi.services;

public class Modelo {
	private String nome;
	private String codigo;
	
	Modelo(){
		
	}
	
	Modelo(String nome, String codigo){
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
