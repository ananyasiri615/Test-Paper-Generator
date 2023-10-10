package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tpg.model.Admin;
import com.tpg.repository.Adminrepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private Adminrepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserDetails member = repo.loadByusername(username);
    	if(member==null) {
    		throw new UsernameNotFoundException("User not found");
    	}
        return member;
    }
   
    public String register(Admin admin) {
    	int response=repo.Register(admin);
    	if(response>0) {
    		return "success";
    	}
    	else if(response <0) {
    		return "Account already exists with provided details";
    	}
    	else {
    		return "failure";
    	}
    }
    
    
}