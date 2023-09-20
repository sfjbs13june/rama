package com.hospital.rama.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class PatientSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/save/patient").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/patient").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.GET, "/get/patient").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.GET, "/get/header").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.DELETE, "/remove/patient").hasAnyRole("ADMIN").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("doctor01").password("{noop}password").roles("DOCTOR").
                and().withUser("doctor02").password("{noop}password").roles("DOCTOR").and()
                .withUser("admin01").password("{noop}password").roles("ADMIN").and().withUser("admin02").password("{noop}password")
                .roles("ADMIN");
    }
}
