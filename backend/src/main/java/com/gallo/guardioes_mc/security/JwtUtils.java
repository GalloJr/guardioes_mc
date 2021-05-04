package com.gallo.guardioes_mc.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gallo.guardioes_mc.dto.MemberDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    
    private static final String KEY = "spring.jwt.sec";
    
    /*
     * Método para gerar toKen
     */
    
    public static String generateToken(User member) 
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MemberDTO usuarioSemSenha = new MemberDTO();
        usuarioSemSenha.setName(member.getUsername());
        if(!member.getAuthorities().isEmpty()) {
            usuarioSemSenha.setAutorizacao(
            		member.getAuthorities().iterator()
                    .next().getAuthority());
        }
        String usuarioJson = mapper.writeValueAsString(usuarioSemSenha);
        Date agora = new Date();
        Long hora = 1000L * 60L * 60L; // Uma hora
        return Jwts.builder().claim("userDetails", usuarioJson)
            .setIssuer("com.gallo.guardioes_mc")
            .setSubject(member.getUsername())
            .setExpiration(new Date(agora.getTime() + hora))
            .signWith(SignatureAlgorithm.HS512, KEY)
            .compact();
    }
    
    /*
     * Método para utilizar token.
     */
    
    public static User parseToken(String token) 
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("userDetails", String.class);
        MemberDTO member = mapper
                .readValue(credentialsJson, MemberDTO.class);
        return (User) User.builder().username(member.getName())
                .password("secret")
                .authorities(member.getAutorizacao())
                .build();
    }

    

}