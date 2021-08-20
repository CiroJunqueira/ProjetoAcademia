package com.ciro.proj;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ciro.proj.domain.Permission;
import com.ciro.proj.domain.User;
import com.ciro.proj.repository.PermissionRepository;
import com.ciro.proj.repository.UserRepository;

@SpringBootApplication
public class ProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, PermissionRepository permissionRepository, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userRepository, permissionRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository,
			BCryptPasswordEncoder passwordEncoder) {
		Permission permission = null;
		Permission findPermission = permissionRepository.findByDescription("Admin");
		Permission findPermissionAluno = permissionRepository.findByDescription("Aluno");
		
		if (null == findPermission) {
			permission = new Permission();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}
		
		if (null == findPermissionAluno) {
			permission = new Permission();
			permission.setDescription("Aluno");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}
		
		User admin = new User();
		admin.setUserName("renprata@hotmail.com");
		admin.setName("Renato");
		admin.setDtCriacao(LocalDateTime.now());
		admin.setDtAtualizacao(LocalDateTime.now());
		admin.setAccountNonExpired(true);
		admin.setAccountNonLocked(true);
		admin.setCredentialsNonExpired(true);
		admin.setEnabled(true);
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setPermissions(Arrays.asList(permission));
		
		User find = userRepository.findByUserName("renprata@hotmail.com");
		if (null == find) {
			userRepository.save(admin);
		}
		
	}
	
}
