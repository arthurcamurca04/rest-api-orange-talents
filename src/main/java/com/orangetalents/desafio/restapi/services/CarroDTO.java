package com.orangetalents.desafio.restapi.services;

public class CarroDTO {
	private String nome;
	private String codigo;
	
	CarroDTO(){}
	CarroDTO(String nome, String codigo){this.nome = nome; this.codigo = codigo;}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {return nome;}	
	public void setNome(String nome) {this.nome = nome;}
}
