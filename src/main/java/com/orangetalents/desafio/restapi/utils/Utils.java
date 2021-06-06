package com.orangetalents.desafio.restapi.utils;

import java.time.LocalDate;

public final class Utils {
	
	public static int obterUltimoDigitoAno(String ano) {
		if(ano != null) {
			return Integer.parseInt(ano.substring(3));
		}
		return -1;
	}
	
	public static int obterDiaRodizio(int dia_rodizio, int ultimoDigitoAno) {
		if(ultimoDigitoAno == 0 || ultimoDigitoAno == 1) {
			dia_rodizio = DiasDaSemana.SEGUNDA_FEIRA.getDiaSemanaOrdinal();
		}if(ultimoDigitoAno == 2 || ultimoDigitoAno == 3) {
			dia_rodizio = DiasDaSemana.TERCA_FEIRA.getDiaSemanaOrdinal();
		}if(ultimoDigitoAno == 4 || ultimoDigitoAno == 5) {
			dia_rodizio = DiasDaSemana.QUARTA_FEIRA.getDiaSemanaOrdinal();
		}if(ultimoDigitoAno == 6 || ultimoDigitoAno == 7) {
			dia_rodizio = DiasDaSemana.QUINTA_FEIRA.getDiaSemanaOrdinal();
		}if(ultimoDigitoAno == 8 || ultimoDigitoAno == 9) {
			dia_rodizio = DiasDaSemana.SEXTA_FEIRA.getDiaSemanaOrdinal();
		}
		return dia_rodizio;
	}
	
	public static boolean isRodizioAtivo(int dia_rodizio, boolean rodizio_ativo) {
		int diaSemanaAtual = LocalDate.now().getDayOfWeek().ordinal();
		if(dia_rodizio == diaSemanaAtual) {
			rodizio_ativo = true;
		}		
		return rodizio_ativo;
	}
}
