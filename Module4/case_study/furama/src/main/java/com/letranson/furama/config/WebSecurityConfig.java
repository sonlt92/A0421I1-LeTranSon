//package com.letranson.furama.config;
//
//import javax.sql.DataSource;
//
//import com.letranson.furama.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers( "/", "/logout").permitAll();
//
//        http.authorizeRequests().antMatchers("/home","/customer/*","/contract/*","/service/*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//
//        http.authorizeRequests().antMatchers("/employee/*").access("hasRole('ROLE_ADMIN')");
//
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
//        http.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/login")
//                .loginPage("/")
//                .defaultSuccessUrl("/loginSuccess")
//                .failureUrl("/")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess")
//                .and().logout().deleteCookies("JSESSIONID");
//
//        http.rememberMe().userDetailsService(this.userDetailsService)
//                .tokenValiditySeconds(86400);
//
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//        db.setDataSource(dataSource);
//        return db;
//    }
//
//}