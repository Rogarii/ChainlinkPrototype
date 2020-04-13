package com.chainlinkproto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.chainlinkproto.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.headers().frameOptions().sameOrigin()
		.and()
		.authorizeRequests().antMatchers("/login", "/resources/**", "/newUser", "/", "/createUser", "/images/**", "/css/**", "/js/**").permitAll()
		.and()
		.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN")
		.and()
		.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN", "USER")
		.and()
		.formLogin().loginPage("/login")
			.loginProcessingUrl("/doLogin")
			.successForwardUrl("/postLogin")
			.failureUrl("/loginFailed")
			.permitAll()
			.and()
			.logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
			.and()
			.csrf().disable();
	}
}
