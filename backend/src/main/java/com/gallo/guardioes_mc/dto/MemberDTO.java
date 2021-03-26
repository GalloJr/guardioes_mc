package com.gallo.guardioes_mc.dto;

import java.io.Serializable;

import com.gallo.guardioes_mc.entities.FinancialStatus;
import com.gallo.guardioes_mc.entities.Member;

public class MemberDTO implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Integer since;
	private String motorcycle;
	private String rank;
	private String sponsor;
	private String imageUri;
	private FinancialStatus status;
	
	public MemberDTO() {
	}

	public MemberDTO(Long id, String name, Integer since, String motorcycle, String rank, String sponsor,
			String imageUri, FinancialStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.since = since;
		this.motorcycle = motorcycle;
		this.rank = rank;
		this.sponsor = sponsor;
		this.imageUri = imageUri;
		this.status = status;
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
	
	
}
