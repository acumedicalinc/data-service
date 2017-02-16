package com.acumedicalinc.web.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	
    	 http.authorizeRequests()
         .antMatchers("/public/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .permitAll()
         .and()
         .logout()
         .permitAll();
    }
}
