package com.orangetalents.desafio.restapi.utils;

public enum DiasDaSemana {
	SEGUNDA_FEIRA(2),
	TERCA_FEIRA(3),
	QUARTA_FEIRA(4),
	QUINTA_FEIRA(5),
	SEXTA_FEIRA(6);
	
	private int diaSemana;
	
	private DiasDaSemana(int diaSemana) {
		this.diaSemana = diaSemana;		
	}
	
	public int getDiaSemanaOrdinal() {
		return diaSemana;
	}
	
	public void setDiaSemanaOrdinal(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	
}
