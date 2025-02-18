package com.app.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.agenda.model.Pessoa;
import com.app.agenda.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/criar")
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.criarPessoa(pessoa);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Pessoa>> listarPessoas(@RequestParam(required = false) String nome) {
		return pessoaService.listarPessoas(nome);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
		return pessoaService.buscarPessoaPorId(id);
	}
	

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa dadosAtualizada) {
		return pessoaService.atualizarPessoa(id, dadosAtualizada);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		return pessoaService.deletar(id);
	}

}
