package com.ciro.proj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ciro.proj.domain.Permission;
import com.ciro.proj.domain.User;
import com.ciro.proj.domain.converter.UserBuilder;
import com.ciro.proj.domain.dto.form.UserForm;
import com.ciro.proj.exception.ErroException;
import com.ciro.proj.repository.PermissionRepository;
import com.ciro.proj.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PermissionRepository permissionRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (null == user) {
			throw new UsernameNotFoundException("Username " + user + " not found");
		}
		return user;
	}

	public User create(UserForm userForm) {
		
		Permission permission = permissionRepository.findByDescription("Aluno");
		
		User userExistente = userRepository.findByUserName(userForm.getUserName());

		if (null != userExistente) {
			throw new ErroException("E-mail já cadastrado!");
		}

		User user = new UserBuilder(permission).build(userForm);

		userRepository.save(user);

		return user;
		
	}

}
