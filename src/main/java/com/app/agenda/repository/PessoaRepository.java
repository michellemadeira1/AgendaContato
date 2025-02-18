package com.app.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.agenda.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

	List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
	
}
