package com.app.agenda.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Schema(description = "ID único da pessoa", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Schema(description = "Nome da pessoa", example = "João da Silva")
	@NotNull
	private String nome;

	@Schema(description = "Endereço da pessoa", example = "Rua ABC, 123")
	private String endereco;

	@Schema(description = "Cidade da pessoa", example = "São Paulo")
	private String cidade;

	@Schema(description = "Estado da pessoa", example = "SP")
	private String uf;

	@Schema(description = "CEP da pessoa", example = "12345-678")
	private String cep;

	@Schema(description = "Lista de contatos associados à pessoa")
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pessoa")
	private List<Contato> contato;

	public Pessoa() {
	}

	public Pessoa(Long id, @NotNull String nome, String endereco, String cidade, String uf, String cep,
			List<Contato> contato) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.contato = contato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

}
