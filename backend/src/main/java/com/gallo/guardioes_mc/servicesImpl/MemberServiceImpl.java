package com.gallo.guardioes_mc.servicesImpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.entities.Autorizacao;
import com.gallo.guardioes_mc.entities.FinancialStatus;
import com.gallo.guardioes_mc.entities.Member;
import com.gallo.guardioes_mc.exceptionhandler.NegocioException;
import com.gallo.guardioes_mc.repositories.AutorizacaoRepository;
import com.gallo.guardioes_mc.repositories.MemberRepository;
import com.gallo.guardioes_mc.services.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;
	
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	// Lista todos usuarios
	@Override
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<Member> Listar() {
		List<Member> members = repository.findAllByOrderBySinceAsc();
		List<Member> membersret = new LinkedList<Member>();
		if(members.isEmpty())
		{
			throw new NegocioException(" Busca sem resultado");
		}
		for (Member member : members) {
			member.setSenha("");
			membersret.add(member);
					
		}
		return membersret;
	}
			
	/*@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<MemberDTO> findAll() {
		List<Member> list = repository.findAllByOrderBySinceAsc();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}*/
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<MemberDTO> findFinancial() {
		List<Member> list = repository.findMembersDelayed();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<MemberDTO> findMembersDirection() {
		List<Member> list = repository.findMembersDirection();
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<MemberDTO> findMembersRank(String rank) {
		List<Member> list = repository.findMembersRank(rank);
		return list.stream().map(x -> new MemberDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public MemberDTO insert(MemberDTO dto) {
		Member member = new Member(null, dto.getName(), dto.getSince(), dto.getMotorcycle(), dto.getRank(), dto.getSponsor(), dto.getImageUri(), dto.getStatus(), dto.getEmail(), dto.getAutorizacao());
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public MemberDTO setAllright(Long id) {
		Member member = repository.getOne(id);
		member.setStatus(FinancialStatus.ALLRIGHT);
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public MemberDTO setDelayed(Long id) {
		Member member = repository.getOne(id);
		member.setStatus(FinancialStatus.DELAYED);
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public MemberDTO setNomad(Long id) {
		Member member = repository.getOne(id);
		member.setRank("Nomade");
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public MemberDTO setMemorian(Long id) {
		Member member = repository.getOne(id);
		member.setRank("In Memorian");
		member = repository.save(member);
		return new MemberDTO(member);
	}
	
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<Member> buscarPorNomeOuEmail(String name, String email)
	{
		List<Member> members = repository.findByNameOrEmailContains(name, email);
		List<Member> membersret = new LinkedList<Member>();
		if(members.isEmpty())
		{
			throw new NegocioException(" Busca sem resultado");
		}
		for (Member member : members) {
			member.setSenha("");
			membersret.add(member);
		
		}
		return membersret;
	}
	
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = repository.findTop1ByNameOrEmail(username, username);
		if (member == null) {
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
		}
		return User.builder().username(username).password(member.getSenha())
				.authorities(member.getAutorizacoes().stream().map(Autorizacao::getNome).collect(Collectors.toList())
						.toArray(new String[member.getAutorizacoes().size()]))
				.build();
	}
	
	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Member newMember(String name, Integer since, String motorcycle, String rank, String sponsor, String imageUri, String email, String senha, String nomeAutorizacao) {
		if (repository.findTop1ByNameOrEmail(name,email)!= null) {
			throw new NegocioException("Já existe um membro cadastrado com este nome ou email.");
		}
		Autorizacao autorizacao = autorizacaoRepo.findByNome(nomeAutorizacao);
		if (autorizacao == null) {
			autorizacao = new Autorizacao();
			autorizacao.setNome(nomeAutorizacao);
			autorizacaoRepo.save(autorizacao);
		}
		
		Member member = new Member();
		member.setName(name);
		member.setSince(since);
		member.setMotorcycle(motorcycle);
		member.setRank(rank);
		member.setSponsor(sponsor);
		member.setImageUri(imageUri);
		member.setEmail(email);
		member.setSenha(passEncoder.encode(senha));
		member.setAutorizacoes(new HashSet<Autorizacao>());
		member.getAutorizacoes().add(autorizacao);
		repository.save(member);
		member.setSenha("");
		return member;
	}
	
	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Member editMember(Long id, MemberDTO memberDto) {
		if (repository.findById(id)== null) {
			throw new NegocioException("Membro não existe.");
		}
		Autorizacao autorizacao = autorizacaoRepo.findByNome(memberDto.getAutorizacao());
		if (autorizacao == null) {
			autorizacao = new Autorizacao();
			autorizacao.setNome(memberDto.getAutorizacao());
			autorizacaoRepo.save(autorizacao);
		}
		
		Member member = new Member();
		member.setId(id);
		member.setName(memberDto.getName());
		member.setSince(memberDto.getSince());
		member.setMotorcycle(memberDto.getMotorcycle());
		member.setRank(memberDto.getRank());
		member.setSponsor(memberDto.getSponsor());
		member.setImageUri(memberDto.getImageUri());
		member.setEmail(memberDto.getEmail());
		member.setSenha(passEncoder.encode(memberDto.getSenha()));
		member.setAutorizacoes(new HashSet<Autorizacao>());
		member.getAutorizacoes().add(autorizacao);
		repository.save(member);
		member.setSenha("");
		return member;
	}
	
	// deleta usuario
	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Member deleteMember(Long memberId) {
		
		repository.deleteById(memberId);
		return null;
	}
}
