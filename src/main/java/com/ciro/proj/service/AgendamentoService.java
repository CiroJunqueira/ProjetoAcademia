package com.ciro.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciro.proj.domain.Agendamento;
import com.ciro.proj.domain.dto.AgendamentoDTO;
import com.ciro.proj.domain.dto.AgendamentoTO;
import com.ciro.proj.exception.ErroException;
import com.ciro.proj.respository.AgendamentoRepository;

@Service
public class AgendamentoService {

	public static final int NUM_MAX = 15;

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public Agendamento marcar(AgendamentoDTO a) {
		Agendamento agendamento = new Agendamento();

		if (a.getHorario().getMinute() != 0) {
			throw new ErroException("Insira somente hora cheia: ex. 18:00, 17:00");
		}

		List<Agendamento> horarios = agendamentoRepository.findByHorario(a.getHorario());

		if (horarios.size() >= NUM_MAX) {
			throw new ErroException("Número limite atingido (máximo " + NUM_MAX + " pessoas)");
		}

		agendamento.setNome(a.getNome());
		agendamento.setHorario(a.getHorario());

		return agendamentoRepository.save(agendamento);

	}

	public Agendamento modificar(String nome, AgendamentoTO a) {
		Agendamento agendamentoSalvo = agendamentoRepository.findByNome(nome);
		if (agendamentoSalvo == null) {
			throw new ErroException("Nome não encontrado.");
		}
		agendamentoSalvo.setHorario(a.getHorario());
		return agendamentoRepository.save(agendamentoSalvo);
	}
}
