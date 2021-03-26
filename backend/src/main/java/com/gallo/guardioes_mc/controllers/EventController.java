package com.gallo.guardioes_mc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gallo.guardioes_mc.dto.EventDTO;
import com.gallo.guardioes_mc.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@GetMapping
	public ResponseEntity<List<EventDTO>> findAll(){
		List<EventDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EventDTO> insert(@RequestBody EventDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/done")
	public ResponseEntity<EventDTO> setDone(@PathVariable Long id) {
		EventDTO dto = service.setDone(id);
		return ResponseEntity.ok().body(dto);
	}
}
