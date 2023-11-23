package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.Admin;
import com.tpg.entity.Candidate;
import com.tpg.service.MyuserDetailsService;



@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SignupController {
	
	@Autowired
	private MyuserDetailsService userDetailsService;
	
	@RequestMapping({"/signup"})
	public String Register(@RequestBody Admin admin) {
		return userDetailsService.register(admin);
		
		
	}

}
