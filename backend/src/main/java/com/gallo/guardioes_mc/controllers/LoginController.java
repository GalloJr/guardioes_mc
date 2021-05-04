package com.gallo.guardioes_mc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gallo.guardioes_mc.dto.MemberDTO;
import com.gallo.guardioes_mc.security.JwtUtils;
import com.gallo.guardioes_mc.services.MemberService;


@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager auth;
    @Autowired
    private MemberService usu;
    
    @PostMapping(path = "/login")
    public MemberDTO login(@RequestBody MemberDTO login) 
            throws JsonProcessingException {
        String username = login.getName();
        if(username == null) {
            username = login.getEmail();
        }
        Authentication credentials = 
                new UsernamePasswordAuthenticationToken(
                        username, login.getSenha());
        User member = (User) auth.authenticate(credentials).getPrincipal();
        UserDetails usuario2 = usu.loadUserByUsername(username);
        login.setSenha(null);
        login.setToken(JwtUtils.generateToken(member));
        login.setAutorizacao(usuario2.getAuthorities().toString());
        
        return login;
    }
    
}
