package com.orangetalents.desafio.restapi.services;

import java.util.ArrayList;
import java.util.List;

public class ModelosDTO {
private List<Modelo> modelos = new ArrayList<Modelo>();
	
	public ModelosDTO() {
	}
	
	public ModelosDTO(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
}
