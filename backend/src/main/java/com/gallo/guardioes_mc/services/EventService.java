package com.gallo.guardioes_mc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.guardioes_mc.dto.EventDTO;
import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.entities.Event;
import com.gallo.guardioes_mc.entities.EventStatus;
import com.gallo.guardioes_mc.entities.Member;
import com.gallo.guardioes_mc.repositories.EventRepository;
import com.gallo.guardioes_mc.repositories.MemberRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Transactional(readOnly = true)
	public List<EventDTO> findAll() {
		List<Event> list = eventRepository.findAll();
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event event = new Event(null, dto.getMoment(), dto.getDescription(), dto.getAddress(), EventStatus.PENDING);
		for (MemberDTO m : dto.getMembers()) {
			Member member = memberRepository.findById(m.getId()).get();
			event.getMembers().add(member);
		}
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
	
	@Transactional
	public EventDTO criarEvento(EventDTO dto) {
		Event event = new Event(null, dto.getMoment(), dto.getDescription(), dto.getAddress(), EventStatus.PENDING);
		for (MemberDTO m : dto.getMembers()) {
			Member member = memberRepository.buscaMemberPorNome(m.getName());
			if(member == null) {
				member = new Member(null, m.getName(), m.getSince(), m.getMotorcycle(), m.getRank(), m.getSponsor(), m.getImageUri(), m.getStatus());
				member = memberRepository.save(member);
			}
			event.getMembers().add(member);
		}
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
	
	@Transactional
	public EventDTO setDone(Long id) {
		Event event = eventRepository.getOne(id);	
		event.setStatus(EventStatus.DONE);
		event = eventRepository.save(event);
		return new EventDTO(event);
	}
}
