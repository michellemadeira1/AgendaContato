package com.app.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato,Long> {
	
	List<Contato> findByPessoaId(Long pessoaId);

}
