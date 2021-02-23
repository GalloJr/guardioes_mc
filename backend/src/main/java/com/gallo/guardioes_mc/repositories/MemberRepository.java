package com.gallo.guardioes_mc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gallo.guardioes_mc.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<Member> findAllByOrderBySinceAsc();
	
	@Query("SELECT DISTINCT obj FROM Member obj WHERE obj.status = 0")
	List<Member> findMembersDelayed();
	
	@Query("SELECT DISTINCT obj FROM Member obj WHERE obj.rank IN ('Presidente', 'Vice Presidente', 'Diretor Eventos', 'Diretor Adjunto Evento', 'Diretor Social', 'Diretor Disciplinar', 'Diretor Tesouraria', 'Diretor Adjunto Tesouraria', 'Diretor Regional Santa Catarina')")
	List<Member> findMembersDirection();
	
	@Query("SELECT DISTINCT obj FROM Member obj WHERE obj.rank Like 'In Memorian'")
	List<Member> findMembersMemorian();
	
	@Query("SELECT DISTINCT obj FROM Member obj WHERE obj.rank Like 'Nomade'")
	List<Member> findMembersNomad();
	
}
