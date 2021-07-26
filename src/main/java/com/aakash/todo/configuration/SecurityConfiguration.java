package com.aakash.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.aakash.todo.model.RoleNames;
import com.aakash.todo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
@AutoConfigureWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/console/**").permitAll()
			.antMatchers("/", "/addNewUser").permitAll()
			.antMatchers("/getAllUser/**", "/removeAll/**").hasAnyAuthority(RoleNames.USER.name())
			.antMatchers("/removeAll/**", "/addNewUser/**", "/save/**", "/register/**", "/delete/**", "/page/**", "/next/**", "/search/**").hasAnyAuthority(RoleNames.USER.name())
			.anyRequest().permitAll()
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout().logoutSuccessUrl("/login")
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.csrf().disable();
		
		http.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/login?error=You are already logged in from somewhere");
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
