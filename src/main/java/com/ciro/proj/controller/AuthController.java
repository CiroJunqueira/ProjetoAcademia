package com.ciro.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciro.proj.config.jwt.JwtTokenProvider;
import com.ciro.proj.domain.dto.form.UserForm;
import com.ciro.proj.repository.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final UserRepository userRepository;

	@GetMapping("/testeSecurity")
	public String teste() {
		return "testado";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserForm userForm) {
		try {

			var userName = userForm.getUserName();
			var password = userForm.getPassword();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

			var user = userRepository.findByUserName(userName);
			var token = "";

			if (null != user) {
				token = jwtTokenProvider.createToken(userName, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username not found");
			}

			Map<Object, Object> model = new HashMap<>();
			model.put("user", user);
			model.put("token", token);

			return ResponseEntity.ok(model);

		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password");
		}
	}
	
}
