package com.gallo.guardioes_mc.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.entities.Member;
import com.gallo.guardioes_mc.services.MemberService;

@RestController
@RequestMapping(value = "/members")
@CrossOrigin
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// método para listar todos membros
	@GetMapping
	public List<Member> Listar() {
		return service.Listar();
	}
	
	@JsonView(View.MemberResumo.class)
	@PostMapping(path = "/nome")
    public List<Member> buscarPorNomeOuEmail(@RequestBody MemberDTO member)
    {
		return service.buscarPorNomeOuEmail(member.getName(), member.getEmail());
    }
	
	//Método para cadastrar membro
	@PostMapping(value = "/novo")
	public Member newMember(@RequestBody @Valid MemberDTO member) {
		return service.newMember(member.getName(), member.getSince(), member.getMotorcycle(), member.getRank(), member.getSponsor(), member.getImageUri(), member.getEmail(), member.getSenha(),
				member.getAutorizacao());
	}	
	
	//Mapeamento para atualizar um membro
	@PutMapping("put/{Id}")
	@ResponseStatus(HttpStatus.OK)
	public Member editMember(@PathVariable Long Id, @RequestBody @Valid MemberDTO memberDto) {
		return service.editMember(Id, memberDto); 
	}
	
	// metodo para deletar usuario
	@DeleteMapping("delete/{memberId}")
	public ResponseEntity<Void> removeMember(@PathVariable Long memberId) {
			
		service.deleteMember(memberId);
		return ResponseEntity.noContent().build();

	}
		
	// método para listar todos membros por ordem de ingresso no M.C.
	/*@JsonView(View.MemberCompleto.class)
	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAll(){
		List<MemberDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}*/
	
	@GetMapping("/financial")
	public ResponseEntity<List<MemberDTO>> findFinancial(){
		List<MemberDTO> list = service.findFinancial();
		return ResponseEntity.ok().body(list);
	}
	
	@JsonView(View.MemberCompleto.class)
	@GetMapping("/director")
	public ResponseEntity<List<MemberDTO>> findMembersDirection(){
		List<MemberDTO> list = service.findMembersDirection();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/patent/{rank}")
	public ResponseEntity<List<MemberDTO>> findMembersRank(@RequestParam(value="rank") String rank){
		List<MemberDTO> list = service.findMembersRank(rank);
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
