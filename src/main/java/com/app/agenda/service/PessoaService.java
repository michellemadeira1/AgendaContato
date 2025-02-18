package com.app.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.agenda.model.Pessoa;
import com.app.agenda.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
		if (pessoa.getId() != null && pessoaRepository.existsById(pessoa.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		Pessoa novaPessoa = pessoaRepository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
	}

	public ResponseEntity<List<Pessoa>> listarPessoas(String nome) {
		List<Pessoa> pessoasExistentes;
		if (nome == null || nome.isEmpty()) {
			pessoasExistentes = pessoaRepository.findAll();
		} else {
			pessoasExistentes = pessoaRepository.findAllByNomeContainingIgnoreCase(nome);
		}
		if (pessoasExistentes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(pessoasExistentes);
	}

	public ResponseEntity<Pessoa> buscarPessoaPorId(Long id) {
		return pessoaRepository.findById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	public ResponseEntity<Pessoa> atualizarPessoa(Long id, Pessoa dadosAtualizada) {
		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setNome(dadosAtualizada.getNome());
			pessoa.setEndereco(dadosAtualizada.getEndereco());
			pessoa.setCidade(dadosAtualizada.getCidade());
			pessoa.setUf(dadosAtualizada.getUf());
			pessoa.setCep(dadosAtualizada.getCep());
			return ResponseEntity.ok(pessoaRepository.save(pessoa));
		}).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	public ResponseEntity<String> deletar(Long id) {
		if (!pessoaRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");
		}
		pessoaRepository.deleteById(id);
		return ResponseEntity.ok("Pessoa deletada com sucesso.");
	}

	public String obterPessoaParaMalaDireta(Long id) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
		if (pessoaOptional.isPresent()) {
			Pessoa pessoa = pessoaOptional.get();
			String malaDireta = String.format("%s, %s – CEP: %s – %s/%s", pessoa.getNome(), pessoa.getEndereco(),
					pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());

			return malaDireta;
		}
		return "Pessoa não encontrada";
	}

}
