package com.ourbabies.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tbl_doador")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Size(min = 3, max = 240)
	private String nome;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Size(min = 11, max = 11)
	private String cpf;
	
	@Size(min = 11, max = 11)
	private String nis_cad;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Email
	private String email;
	
	@NotBlank(message = "Este campo deve ser preenchido")
	@Size(min = 8, max = 16)
	private String senha;
	
	
	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNis_cad() {
		return nis_cad;
	}

	public void setNis_cad(String nis_cad) {
		this.nis_cad = nis_cad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

