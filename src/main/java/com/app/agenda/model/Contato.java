package com.app.agenda.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contato {

	@Schema(description = "ID único do contato", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Schema(description = "Tipo de contato (ex: 1 para celular, 2 para telefone fixo)", example = "1")
	private Integer tipoContato;

	@Schema(description = "Informação de contato (ex: número de telefone ou e-mail)", example = "99999-9999")
	private String contato;

	@Schema(description = "Pessoa associada a este contato")
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Contato() {
	}

	public Contato(Long id, Integer tipoContato, String contato, Pessoa pessoa) {
		super();
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
