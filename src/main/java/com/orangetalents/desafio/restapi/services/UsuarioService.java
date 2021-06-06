package com.orangetalents.desafio.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafio.restapi.exception.EntidadeNaoLocalizadaException;
import com.orangetalents.desafio.restapi.model.Usuario;
import com.orangetalents.desafio.restapi.repository.UsuarioRepository;
import com.orangetalents.desafio.restapi.utils.Utils;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepo;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	public Usuario salvar(Usuario usuario) {
		try {
			usuario.getCarros().forEach(carro -> {
				carro.setUsuario(usuario);
				int ultimoDigitoAno = Utils.obterUltimoDigitoAno(carro.getAno());
				int dia_rodizio = Utils.obterDiaRodizio(carro.getDia_rodizio(), ultimoDigitoAno);
				carro.setDia_rodizio(dia_rodizio);
				boolean rodizio_ativo = Utils.isRodizioAtivo(carro.getDia_rodizio(), carro.getRodizio_ativo());
				carro.setRodizio_ativo(rodizio_ativo);
			});
			return usuarioRepo.save(usuario);
		} catch (Exception e) {
			throw new EntidadeNaoLocalizadaException("Houve um erro ao adicionar usuário");
		}
	}

	public Usuario getUsuario(Long id) {
		try {
			return usuarioRepo.findById(id).get();
		} catch (Exception e) {
			throw new EntidadeNaoLocalizadaException("Houve um erro ao encontrar usuário");
		}

	}
}
