package com.ciro.proj.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ciro.proj.domain.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	@Query("select h from Agendamento h where h.horario =:param")
	List<Agendamento> findByHorario(@Param("param") LocalDateTime param);

	
	
}
