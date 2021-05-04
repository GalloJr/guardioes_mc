package com.gallo.guardioes_mc.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.gallo.guardioes_mc.controllers.View;

@Entity
@Table(name = "tb_member")
public class Member implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@JsonView(View.MemberCompleto.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonView(View.MemberResumo.class)
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
	private String email;
	
	private String senha;
	
	@JsonView(View.MemberResumo.class)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "uau_usuario_autorizacao", joinColumns = { @JoinColumn(name = "member_id") }, inverseJoinColumns = {
			@JoinColumn(name = "aut_id") })
	private Set<Autorizacao> autorizacoes;
	
	public Member() {
	}

	public Member(Long id, String name, Integer since, String motorcycle, String rank, String sponsor, String imageUri, FinancialStatus status, String email, String senha) {
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
	
	public Set<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
	
	public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
