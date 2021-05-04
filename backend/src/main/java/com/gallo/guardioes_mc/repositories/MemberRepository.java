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
	
	@Query("SELECT DISTINCT obj FROM Member obj WHERE obj.rank = ?1")
	List<Member> findMembersRank(String rank);
	
	//@Query("select m from members m where m.nome = ?1 or m.motorcycle = ?2")
    //List<Member> buscaUsuarioPorNomeOuMoto(String name, String motorcycle);
	
	@Query("SELECT m FROM Member m where m.name = ?1")
    public Member findMembersByName(String name);
	
	public Member findTop1ByNameOrEmail(String name, String email);
	
	public List<Member> findByNameOrEmailContains(String name, String email);
	
}
