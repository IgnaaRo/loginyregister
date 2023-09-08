package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private ClienteDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncorder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/auth/**","/public/**","/css/**","/js/**").permitAll().anyRequest().authenticated()
		
		.and()
		    .formLogin().loginPage("/auth/Login").defaultSuccessUrl("/private/index",true).failureUrl("/auth/login?error=true")
		    .loginProcessingUrl("/auth/login-post").permitAll()
		 .and()
		    .logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");
		
	}

	
	
	
}
