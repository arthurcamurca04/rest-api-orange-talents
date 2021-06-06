package com.orangetalents.desafio.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.desafio.restapi.model.Usuario;
import com.orangetalents.desafio.restapi.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(usuarioService.getUsuario(id));
	}

	@PostMapping("/cadastro")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario salvar(@Validated @RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
}
