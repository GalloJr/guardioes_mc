package com.gallo.guardioes_mc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.entities.FinancialStatus;
import com.gallo.guardioes_mc.entities.Member;
import com.gallo.guardioes_mc.repositories.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Transactional(readOnly = true)
	public List<MemberDTO> findAll() {
		List<Member> list = repository.findAllByOrderBySinceAsc();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<MemberDTO> findFinancial() {
		List<Member> list = repository.findMembersDelayed();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<MemberDTO> findMembersDirection() {
		List<Member> list = repository.findMembersDirection();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<MemberDTO> findMembersRank(String rank) {
		List<Member> list = repository.findMembersRank(rank);
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public MemberDTO insert(MemberDTO dto) {
		Member member = new Member(null, dto.getName(), dto.getSince(), dto.getMotorcycle(), dto.getRank(), dto.getSponsor(), dto.getImageUri(), dto.getStatus());
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	public MemberDTO setAllright(Long id) {
		Member member = repository.getOne(id);
		member.setStatus(FinancialStatus.ALLRIGHT);
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	public MemberDTO setDelayed(Long id) {
		Member member = repository.getOne(id);
		member.setStatus(FinancialStatus.DELAYED);
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	public MemberDTO setNomad(Long id) {
		Member member = repository.getOne(id);
		member.setRank("Nomade");
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	public MemberDTO setMemorian(Long id) {
		Member member = repository.getOne(id);
		member.setRank("In Memorian");
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
}
