package com.ciro.proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciro.proj.domain.Usuario;
import com.ciro.proj.domain.form.UsuarioForm;
import com.ciro.proj.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/usuario")
@AllArgsConstructor
public class UsuarioController {

	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody UsuarioForm usuarioForm) {

		Usuario usuarioCriado = usuarioService.criar(usuarioForm);

		return new ResponseEntity<Usuario>(usuarioCriado, HttpStatus.CREATED);
	}

}
