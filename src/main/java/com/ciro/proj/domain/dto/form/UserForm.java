package com.ciro.proj.domain.dto.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {
	 
	 
	private static final long serialVersionUID = 227379723577358323L;

	private String userName;
	
	private String name;
	
	private String password;
	
}
