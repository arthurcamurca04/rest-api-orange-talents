package com.orangetalents.desafio.restapi.services;

public class Carro {
	
	private String Valor;
	private String Marca;
	private String Modelo;
	private String AnoModelo;
	
	public Carro() {
	}
	
	public Carro(String valor, String marca, String modelo, String anoModelo) {
		this.Valor = valor;
		this.Marca = marca;
		this.Modelo = modelo;
		this.AnoModelo = anoModelo;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		this.Valor = valor;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		this.Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}

	public String getAnoModelo() {
		return AnoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.AnoModelo = anoModelo;
	}
}
