package com.ciro.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciro.proj.domain.Agendamento;
import com.ciro.proj.domain.User;
import com.ciro.proj.domain.converter.AgendamentoBuilder;
import com.ciro.proj.domain.dto.AgendamentoTO;
import com.ciro.proj.domain.dto.form.AgendamentoForm;
import com.ciro.proj.exception.ErroException;
import com.ciro.proj.repository.AgendamentoRepository;
import com.ciro.proj.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendamentoService {

	public static final int NUM_MAX = 15;

	private AgendamentoRepository agendamentoRepository;
	private UserRepository userRepository;

	public Agendamento marcar(AgendamentoForm a) {
		Agendamento agendamento = new Agendamento();

		if (a.getHorario().getMinute() != 0) {
			throw new ErroException("Insira somente hora cheia: ex. 18:00, 17:00");
		}

		List<Agendamento> horarios = agendamentoRepository.findByHorario(a.getHorario());

		if (horarios.size() >= NUM_MAX) {
			throw new ErroException("Número limite atingido (máximo " + NUM_MAX + " pessoas)");
		}

		User user = userRepository.findByUserName(a.getUserName());
		Agendamento ag = new AgendamentoBuilder(agendamento).build(a, user);

		return agendamentoRepository.save(ag);

	}

	public Agendamento modificar(String email, AgendamentoTO a) {
//		Agendamento agendamentoSalvo = agendamentoRepository.findb
//		if (agendamentoSalvo == null) {
//			throw new ErroException("Nome não encontrado.");
//		}
//		agendamentoSalvo.setHorario(a.getHorario());
//		return agendamentoRepository.save(agendamentoSalvo);
		return null;
	}
}
