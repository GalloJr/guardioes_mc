package com.gallo.guardioes_mc.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.services.MemberService;

@RestController
@RequestMapping(value = "/members")
@CrossOrigin
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAll(){
		List<MemberDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/financial")
	public ResponseEntity<List<MemberDTO>> findFinancial(){
		List<MemberDTO> list = service.findFinancial();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/director")
	public ResponseEntity<List<MemberDTO>> findMembersDirection(){
		List<MemberDTO> list = service.findMembersDirection();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/nomad")
	public ResponseEntity<List<MemberDTO>> findMembersNomad(){
		List<MemberDTO> list = service.findMembersNomad();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/memorian")
	public ResponseEntity<List<MemberDTO>> findMembersMemorian(){
		List<MemberDTO> list = service.findMembersMemorian();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<MemberDTO> insert(@RequestBody MemberDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/allright")
	public ResponseEntity<MemberDTO> setAllright(@PathVariable Long id) {
		MemberDTO dto = service.setAllright(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/{id}/delayed")
	public ResponseEntity<MemberDTO> setDelayed(@PathVariable Long id) {
		MemberDTO dto = service.setDelayed(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/{id}/nomad")
	public ResponseEntity<MemberDTO> setNomad(@PathVariable Long id) {
		MemberDTO dto = service.setNomad(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/{id}/memorian")
	public ResponseEntity<MemberDTO> setMemorian(@PathVariable Long id) {
		MemberDTO dto = service.setMemorian(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
