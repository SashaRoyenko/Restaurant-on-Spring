package com.robosh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration", "/test").permitAll()
                .antMatchers("/home", "/about", "/menu").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("USER")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
//                .logoutSuccessUrl("/home")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder())
                .usersByUsernameQuery("select email, password, true from user where email=?")
                .authoritiesByUsernameQuery("select email, role from user where email=?");
    }



//    @Bean
//    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//        StrictHttpFirewall fireWall = new StrictHttpFirewall();
//        fireWall.setAllowUrlEncodedSlash(true);
//        return fireWall;
//    }
//
//    @Bean
//    public HttpFirewall defaultHttpFirewall() {
//        return new DefaultHttpFirewall();
//    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web
//                .httpFirewall(defaultHttpFirewall())
                .ignoring()
                .antMatchers("/css/**", "/images/**", "/js/**", "/fonts/**");
    }

}