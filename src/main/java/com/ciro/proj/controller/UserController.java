package com.ciro.proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciro.proj.domain.User;
import com.ciro.proj.domain.dto.form.UserForm;
import com.ciro.proj.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserForm userForm) {

		User createdUser = userService.create(userForm);

		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
}
