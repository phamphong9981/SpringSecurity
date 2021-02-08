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
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // account kai/123456
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("kai")
                .password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");
        // account sena/123456
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("sena")
                .password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("USER");
        // auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("sena").password("123456").roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Cấu hình cho Login Form.
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER").and()
                .formLogin()//
                .loginProcessingUrl("/j_spring_security_login")//
                .loginPage("/login2")//
                .defaultSuccessUrl("/user")//
                .failureUrl("/login2?message=error")//
                .usernameParameter("username").passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login2?message=logout");
    }
}
