package com.gallo.guardioes_mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.gallo.guardioes_mc.controllers.View;
import com.gallo.guardioes_mc.entities.FinancialStatus;
import com.gallo.guardioes_mc.entities.Member;

public class MemberDTO implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@JsonView(View.MemberCompleto.class)
	private Long id;
	
	@JsonView(View.MemberResumo.class)
	@NotBlank (message = "{name.not.blank}")
	private String name;
	
	@JsonView(View.MemberCompleto.class)
	private Integer since;

	@JsonView(View.MemberResumo.class)
	private String motorcycle;
	
	@JsonView(View.MemberResumo.class)
	private String rank;
	
	@JsonView(View.MemberCompleto.class)
	private String sponsor;
	
	@JsonView(View.MemberCompleto.class)
	private String imageUri;
	
	@JsonView(View.MemberCompleto.class)
	private FinancialStatus status;

	@JsonView(View.MemberResumo.class)
	@NotBlank 
	@Email 
	@Size(max= 255) 
	private String email;
	
	private String senha;
	
	@JsonView(View.MemberResumo.class)
	private String autorizacao;
	
	private String token;
	
	public MemberDTO() {
	}

	public MemberDTO(Long id, String name, Integer since, String motorcycle, String rank, String sponsor,
			String imageUri, FinancialStatus status, String email, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.since = since;
		this.motorcycle = motorcycle;
		this.rank = rank;
		this.sponsor = sponsor;
		this.imageUri = imageUri;
		this.status = status;
		this.email = email;
		this.senha = senha;
	}
	
	public MemberDTO(Member entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		since = entity.getSince();
		motorcycle = entity.getMotorcycle();
		rank = entity.getRank();
		sponsor = entity.getSponsor();
		imageUri = entity.getImageUri();
		status = entity.getStatus();
		email = entity.getEmail();
		senha = entity.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSince() {
		return since;
	}

	public void setSince(Integer since) {
		this.since = since;
	}

	public String getMotorcycle() {
		return motorcycle;
	}

	public void setMotorcycle(String motorcycle) {
		this.motorcycle = motorcycle;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public FinancialStatus getStatus() {
		return status;
	}

	public void setStatus(FinancialStatus status) {
		this.status = status;
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
	
	public String getAutorizacao() {
		return autorizacao;
	}
	
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}
