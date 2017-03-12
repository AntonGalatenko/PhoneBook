//package com.toxa.phonebook2.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
////        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
////        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
////    }
//
//    @Autowired
//    @Qualifier("customUserDetailsService")
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/login**").permitAll()
//                .antMatchers("/register**").permitAll()
//                .antMatchers("/*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_PRO-USER')")
//                .and().formLogin()
//                .defaultSuccessUrl("/login", false)
//
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .usernameParameter("j_username").passwordParameter("j_password")
//                .defaultSuccessUrl("/")
//                .and().rememberMe()
//                .and().csrf().disable();
//
//    }
//}
//
