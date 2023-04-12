package com.inti.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService uds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login", "/inscription", "/accueil").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/artiste/**").hasAnyRole("ARTISTE", "ADMIN")
			.antMatchers("/proprietaire/**").hasAnyRole("PROPRIETAIRE", "ADMIN")
			.antMatchers("/utilisateur/**").hasAnyRole("UTILISATEUR", "ARTISTE", "PROPRIETAIRE", "ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/accueil");
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authProvider());
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("root")).roles("ADMIN")
		.and()
		.withUser("proprietaire").password(passwordEncoder().encode("root")).roles("PROPRIETAIRE")
		.and()
		.withUser("artiste").password(passwordEncoder().encode("root")).roles("ARTISTE")
		.and()
		.withUser("client").password(passwordEncoder().encode("root")).roles("CLIENT");
		
	} // Compare les infos de l'utilisateur récupéré et le mdp crypté
	
	@Bean
	public DaoAuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider authP = new DaoAuthenticationProvider();
		authP.setUserDetailsService(uds);
		authP.setPasswordEncoder(passwordEncoder());
		return authP;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
