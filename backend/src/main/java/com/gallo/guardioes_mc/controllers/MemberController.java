package com.gallo.guardioes_mc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.services.MemberService;

@RestController
@RequestMapping(value = "/members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAll(){
		List<MemberDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
