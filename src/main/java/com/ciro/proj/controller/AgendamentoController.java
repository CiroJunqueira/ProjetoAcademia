package com.ciro.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciro.proj.domain.Agendamento;
import com.ciro.proj.domain.dto.AgendamentoTO;
import com.ciro.proj.domain.dto.form.AgendamentoForm;
import com.ciro.proj.repository.AgendamentoRepository;
import com.ciro.proj.service.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private AgendamentoService agendamentoService;

	@GetMapping
	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agendamento marcar(@RequestBody AgendamentoForm a) {
		return agendamentoService.marcar(a);
	}

	@PutMapping("/{nome}")
	public Agendamento modificar(@PathVariable String nome, @RequestBody AgendamentoTO a) throws Exception {
		return agendamentoService.modificar(nome, a);
	}

}
