package com.ciro.proj.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGENDAMENTO_ID")
	private Long agendamentoId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "HORARIO")
	private LocalDateTime horario;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	@JsonIgnore
	private User user;

	@Column(name = "DT_CRIACAO")
	private LocalDateTime dtCriacao;

	@Column(name = "DT_ATUALIZACAO")
	private LocalDateTime dtAtualizacao;

}
