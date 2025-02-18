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
import org.springframework.web.bind.annotation.RestController;

import com.app.agenda.model.Contato;
import com.app.agenda.service.ContatoService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	  @Autowired
	    private ContatoService contatoService;
	  
	  
		@PostMapping("/")
		public ResponseEntity<Contato> criarContato(@RequestBody Contato contato) {
			return contatoService.adicionarContato(contato);
		}
	  
	  @GetMapping("/{id}")
	    public ResponseEntity<Contato> obterContatoPorId(@PathVariable Long id) {
	        return contatoService.obterContatoPorId(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	  
	  @GetMapping("/pessoa/{idPessoa}")
	    public List<Contato> listarContatosPorPessoa(@PathVariable Long idPessoa) {
	        return contatoService.listarContatosPorPessoa(idPessoa);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<Contato> atualizarContato(@PathVariable Long id, @RequestBody Contato contato) {
	        return ResponseEntity.ok(contatoService.atualizarContato(id, contato));
	    }
	  
	  @DeleteMapping("/deletar/{id}")
		public ResponseEntity<String> deletar(@PathVariable Long id) {
			return contatoService.deletar(id);
		}

}
