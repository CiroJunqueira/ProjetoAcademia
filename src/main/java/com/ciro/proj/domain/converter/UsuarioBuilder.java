package com.ciro.proj.domain.converter;

import java.time.LocalDateTime;

import com.ciro.proj.domain.Usuario;
import com.ciro.proj.domain.form.UsuarioForm;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioBuilder {

	public Usuario build(UsuarioForm usuarioForm) {
		return Usuario.builder().nome(usuarioForm.getNome()).email(usuarioForm.getEmail())
				.password(usuarioForm.getPassword()).dtCriacao(LocalDateTime.now()).dtAtualizacao(LocalDateTime.now())
				.build();
	}

}
