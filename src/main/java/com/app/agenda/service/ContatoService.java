package com.app.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.agenda.model.Contato;
import com.app.agenda.model.Pessoa;
import com.app.agenda.repository.ContatoRepository;
import com.app.agenda.repository.PessoaRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<Contato> adicionarContato(Contato contato) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(contato.getPessoa().getId());

		if (pessoaOptional.isPresent()) {
			contato.setPessoa(pessoaOptional.get());
			Contato novoContato = contatoRepository.save(contato);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public Optional<Contato> obterContatoPorId(Long id) {
		return contatoRepository.findById(id);
	}

	public List<Contato> listarContatosPorPessoa(Long pessoaId) {
		return contatoRepository.findByPessoaId(pessoaId);
	}

	public Contato atualizarContato(Long id, Contato contatoAtualizado) {
		Optional<Contato> contatoExistente = contatoRepository.findById(id);
		if (contatoExistente.isPresent()) {
			Contato contato = contatoExistente.get();
			contato.setTipoContato(contatoAtualizado.getTipoContato());
			contato.setContato(contatoAtualizado.getContato());
			if (contatoAtualizado.getPessoa() != null) {
				contato.setPessoa(contatoAtualizado.getPessoa());
			}
			return contatoRepository.save(contato);
		} else {
			return null;
		}
	}

	public ResponseEntity<String> deletar(Long id) {
		if (!contatoRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado.");
		}
		contatoRepository.deleteById(id);
		return ResponseEntity.ok("Contato deletado com sucesso.");
	}
}
