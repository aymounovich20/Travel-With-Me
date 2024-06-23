package com.rma.travelwithme.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/group/**").hasRole("GROUP_LEADER")
//                .antMatchers("/user/**").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user").password("{noop}password").roles("USER")
//            .and()
//            .withUser("group_leader").password("{noop}password").roles("GROUP_LEADER")
//            .and()
//            .withUser("admin").password("{noop}password").roles("ADMIN");
//    }
}

