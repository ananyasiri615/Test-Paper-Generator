package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tpg.security.JwtRequestFilter;
import com.tpg.service.MyuserDetailsService;

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private MyuserDetailsService myUserDetailsServicee;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsServicee);
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers(
                        "/authenticate",
						"/api/candidate/signup",
						"/candidate/loginuser/{token}",
						"/sections/all",
						"/questions/update/{q_id}",
						"/questions/delete/{q_id}",
						"/questions/create",
						"/sections/create",
						"/sections/update/{sectionId}",
						"/sections/delete/{sectionId}",
						"/sections/id/{section_id}",
						"/subjects/create",
						"/subjects/all",
						"/questions/update/{q_id}",
						"/questions/delete/{q_id}",
						"/questions/createMultiple",
						"/questions/id/{q_id}",
						"/questions/all",
						"/sections/generate?subjectId={subjectId}&numberOfQuestions={numberOfQuestions}",
						"/subjects/update/{subjectId}",
						"/subjects/delete/{subjectId}",
						"/candidates/all","/candidates/create",
						"/candidates/update/{candidateId}",
						"/candidates/delete/{candidateId}",
						"/candidates/{candidateId}","/sections/generate",
						"/sections/delete/${section_id}",
						"/sections/update/${section_id}","/sections/id/${section_id}",
						"/sections/all","/useranswer/report","/useranswer/gettotal",
						"/api/signup","/candidates/create","/admins/create",
						"/useranswer/historyreport/{username}","/testpapers/createwithdate/**",
						"/testpapers/create","/testpapers/all","/candidatehistory/add",
						"/useranswer/historyreport/{username}","/testpapers/createwithdate/**",
						"/testHistory/createTestHistoryList",
						"/testHistory/byUsername/{username}",
						"/candidatehistory/all",
						"/feedback/submit",
						"/feedback/all",
						"/testpapers/create","/testpapers/all","/candidatehistory/add",
			        	"/contact/submit",
				"/contact/all"
						).permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
//}
//
////authenticate","/api/signup","/candidate/loginuser/{token}","/sections/all","/sections/create","/sections/update/{section_id}","/sections/delete/{section_id}","/sections/id/{section_id}","/subjects/create","/questions/createMultiple","/sections/generate?subjectId={}&numberOfQuestions={}","/questions/all"
////"/admin/loginuser/{token}","/candidate/loginuser/{token}",
//
