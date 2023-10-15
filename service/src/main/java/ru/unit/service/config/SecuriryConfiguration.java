package ru.unit.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.unit.service.crud.repository.services.PersonDetailsService;

@Configuration
@EnableWebSecurity
public class SecuriryConfiguration{
	
	private final PersonDetailsService personDetailsService;
	
	@Autowired
	public SecuriryConfiguration(PersonDetailsService personDetailsService) {
		this.personDetailsService = personDetailsService;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests(auth -> {
				auth
				.requestMatchers("/error", "/authorization/login",
				"/authorization/**", "/authorization/message/{code}",
				"/user", "/user/{id}",
				"/project", "/project/{id}",
				"/admin/**", "/user/{id}/**",
				"/redirect/**", "/project/{id}/**")
				.permitAll()
				.anyRequest().hasRole("USER");
			}).formLogin(formLogin ->{
				formLogin
				.loginPage("/authorization/login")
				.usernameParameter("login")
				.passwordParameter("password")
				.loginProcessingUrl("/authorization/login")
				.defaultSuccessUrl("/redirect/user", true)
				.failureUrl("http://google.com");
			}).logout(logout -> {
				logout
				.logoutUrl("/authorization/logout")
				.logoutSuccessUrl("/authorization/login");
			});
		return http.build();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(personDetailsService);
		return daoAuthenticationProvider;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return  new BCryptPasswordEncoder();
	}
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}
