package com.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class CustomSecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("/welcome").authenticated()
				.antMatchers("/admin").hasAuthority("ROLE_ADMIN")
				.antMatchers("/emp").hasAuthority("ROLE_EMP")
				.antMatchers("/mgr").hasAuthority("ROLE_MGR")
				.antMatchers("/common").hasAnyAuthority("ROLE_EMP", "ROLE_ADMIN","ROLE_MGR")
				
				.anyRequest().authenticated()
				
				.and()
				.formLogin()   // web login page
				.defaultSuccessUrl("/welcome",true)
				
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username,password,enabled from users where username=?")
			.authoritiesByUsernameQuery("select username,role from users where username=?")
			.passwordEncoder(encoder);
	}
}
