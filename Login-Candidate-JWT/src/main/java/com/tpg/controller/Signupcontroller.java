package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.model.Candidate;
import com.tpg.service.MyUserDetailsService;



@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class Signupcontroller {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@RequestMapping({"/signup"})
	public String Register(@RequestBody Candidate candidate) {
		return userDetailsService.register(candidate);
		
		
	}
	

}
