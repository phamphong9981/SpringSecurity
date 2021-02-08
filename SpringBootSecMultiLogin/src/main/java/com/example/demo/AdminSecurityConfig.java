package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // account kai/admin1234
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("kai")
                .password("$2a$04$PQtbtSAHZgBXLN.K/gZ3/eomQtZkB8R7x03KqZJxOTAbLRkxD9jgC").roles("ADMIN");
        // account sena/123456
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("sena")
                .password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
        // auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("sena").password("123456").roles("USER");
    }
    protected void configure(HttpSecurity http) throws Exception {
        // Cấu hình security/form login cho url /admin/**
        // Cấu hình cho Login Form.
        http.antMatcher("/admin/**").authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").and().formLogin()//
                .loginProcessingUrl("/admin/j_spring_security_login")//
                .loginPage("/login1")//
                .defaultSuccessUrl("/admin/admin")//
                .failureUrl("/login1?message=error")//
                .usernameParameter("username")//
                .passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().logout().logoutUrl("/admin/j_spring_security_logout").logoutSuccessUrl("/login1?message=logout");
    }
}
