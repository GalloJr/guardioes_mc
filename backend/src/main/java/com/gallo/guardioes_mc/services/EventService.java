package com.gallo.guardioes_mc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.guardioes_mc.dto.EventDTO;
import com.gallo.guardioes_mc.entities.Event;
import com.gallo.guardioes_mc.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {
		List<Event> list = repository.findAll();
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event event = new Event(null, dto.getMoment(), dto.getDescription(), dto.getAddress());
		event = repository.save(event);
		return new EventDTO(event);
	}
}
