package com.ciro.proj.service;

import org.springframework.stereotype.Service;

import com.ciro.proj.domain.Usuario;
import com.ciro.proj.domain.converter.UsuarioBuilder;
import com.ciro.proj.domain.form.UsuarioForm;
import com.ciro.proj.exception.ErroException;
import com.ciro.proj.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public Usuario criar(UsuarioForm usuarioForm) {

		Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioForm.getEmail());

		if (null != usuarioExistente) {
			throw new ErroException("E-mail já está sendo utilizado");
		}

		Usuario usuario = new UsuarioBuilder().build(usuarioForm);

		usuarioRepository.save(usuario);

		return usuario;
	}

}
