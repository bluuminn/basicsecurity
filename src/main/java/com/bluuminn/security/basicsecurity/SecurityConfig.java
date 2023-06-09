package com.bluuminn.security.basicsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin()
//                .loginPage("/login-page")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("passwd")
                .loginProcessingUrl("/login-proc")
                .successHandler((request, response, authentication) -> {
                    System.out.println("authentication = " + authentication.getName());
                    response.sendRedirect("/");
                })
                .failureHandler((request, response, exception) -> {
                    System.out.println("exception = " + exception.getMessage());
                    response.sendRedirect("/login");
                })
                .permitAll()
        ;
    }
}
