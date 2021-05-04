package com.gallo.guardioes_mc.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.entities.Member;

public interface MemberService extends UserDetailsService{
	
	public Member newMember(String name, Integer since, String motorcycle, String rank, String sponsor, String imageUri, String email, String senha, String nomeAutorizacao);
	
	public Member editMember(Long id, MemberDTO memberDto);
	
	
	public List<Member> Listar();
	public List<Member> buscarPorNomeOuEmail(String name, String email);
	

	public Member deleteMember(Long memberId);

	//public List<MemberDTO> findAll();

	public List<MemberDTO> findFinancial();

	public List<MemberDTO> findMembersDirection();

	public MemberDTO insert(MemberDTO dto);

	public MemberDTO setAllright(Long id);

	public MemberDTO setDelayed(Long id);

	public MemberDTO setNomad(Long id);

	public MemberDTO setMemorian(Long id);

	public List<MemberDTO> findMembersRank(String rank);
}

