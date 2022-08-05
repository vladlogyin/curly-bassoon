package com.sparta.curlybassoon.configs;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@Configuration
public class NorthwindConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("testuser")
                .password(passwordEncoder().encode("secret123"))
                .roles("USER")
                .and()
                .withUser("testadmin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN","USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                /**** Resources ****/
                /*.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/bootstrap/**").permitAll()
                .antMatchers("/images/**").permitAll()*/
                /***** Web App ****/
                .antMatchers("/basket**").hasAnyRole("USER")
                .antMatchers("/orders").hasAnyRole("USER","ADMIN")
                .antMatchers("/products").hasAnyRole("USER","ADMIN")
                .antMatchers("/welcome").hasAnyRole("USER","ADMIN")
                .antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/product/**").hasAnyRole("ADMIN")
                .antMatchers("/employee**").hasAnyRole("ADMIN")
                .antMatchers("/customer**").hasAnyRole("ADMIN")
                .and().exceptionHandling().accessDeniedPage("/access-denied")
                /**** login forms *****/
                .and().formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/welcome")
                .failureUrl("/access-denied")
                .and().logout().logoutUrl("/signout").logoutSuccessUrl("/signedout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
