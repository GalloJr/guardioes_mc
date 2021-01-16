package com.gallo.guardioes_mc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.guardioes_mc.dto.MemberDTO;
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
}
