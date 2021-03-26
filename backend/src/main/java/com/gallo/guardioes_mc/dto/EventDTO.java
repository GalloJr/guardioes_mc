package com.gallo.guardioes_mc.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gallo.guardioes_mc.entities.Event;
import com.gallo.guardioes_mc.entities.EventStatus;

public class EventDTO implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private String description;
	private String address;
	private EventStatus status;
	
	private List<MemberDTO> members = new ArrayList<>();
	
	public EventDTO() {
		
	}

	public EventDTO(Long id, Instant moment, String description, String address, EventStatus status) {
		super();
		this.id = id;
		this.moment = moment;
		this.description = description;
		this.address = address;
		this.status = status;
	}

	public EventDTO(Event entity) {
		super();
		id = entity.getId();
		moment = entity.getMoment();
		description = entity.getDescription();
		address = entity.getAddress();
		status = entity.getStatus();
		members = entity.getMembers().stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public EventStatus getStatus() {
		return status;
	}

	public void setStatus(EventStatus status) {
		this.status = status;
	}
	
	public List<MemberDTO> getMembers() {
		return members;
	}
}
