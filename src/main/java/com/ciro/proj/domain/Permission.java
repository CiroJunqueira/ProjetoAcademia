package com.ciro.proj.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERMISSION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements GrantedAuthority, Serializable {
	
	private static final long serialVersionUID = 8639912746462960469L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Override
	public String getAuthority() {
		return this.description;
	}

}
