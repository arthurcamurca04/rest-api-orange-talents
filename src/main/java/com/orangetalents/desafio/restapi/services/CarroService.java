package com.orangetalents.desafio.restapi.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "parallelum", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface CarroService {
	@GetMapping("/marcas")
	public List<CarroDTO> getMarcas();
	
	@GetMapping("/marcas/{id}/modelos")
	public ModelosDTO getModelos(@PathVariable Integer id);
	
	@GetMapping("/marcas/{marcaID}/modelos/{modeloID}/anos")
	public List<CarroDTO> getAnos(@PathVariable Integer marcaID, @PathVariable Integer modeloID);
	
	@GetMapping("/marcas/{marcaID}/modelos/{modeloID}/anos/{codigo}")
	public Carro getValor(@PathVariable Integer marcaID, @PathVariable Integer modeloID, @PathVariable String codigo);

}
