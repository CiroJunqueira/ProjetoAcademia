package com.ciro.proj.domain.converter;

import java.time.LocalDateTime;

import com.ciro.proj.domain.Agendamento;
import com.ciro.proj.domain.User;
import com.ciro.proj.domain.dto.form.AgendamentoForm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgendamentoBuilder {
	
	private final Agendamento agendamento;
	
	public Agendamento build(AgendamentoForm agendamentoForm, User user) {
		agendamento.setUser(user);
		agendamento.setHorario(agendamentoForm.getHorario());
		agendamento.setDtCriacao(LocalDateTime.now());
		agendamento.setDtAtualizacao(LocalDateTime.now());
		return agendamento;
	}

}
