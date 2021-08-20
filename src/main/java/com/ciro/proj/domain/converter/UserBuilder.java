package com.ciro.proj.domain.converter;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ciro.proj.domain.Permission;
import com.ciro.proj.domain.User;
import com.ciro.proj.domain.dto.form.UserForm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserBuilder {
	
	private Permission permission;

	public User build(UserForm usuarioForm) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return User.builder().name(usuarioForm.getName()).userName(usuarioForm.getUserName())
				.password(bCryptPasswordEncoder.encode(usuarioForm.getPassword())).dtCriacao(LocalDateTime.now()).dtAtualizacao(LocalDateTime.now())
				.accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
				.permissions(Arrays.asList(permission)).build();
	}

}
