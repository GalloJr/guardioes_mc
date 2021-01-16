package com.gallo.guardioes_mc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallo.guardioes_mc.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<Member> findAllByOrderBySinceAsc();
}
