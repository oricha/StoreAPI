package com.kmuniz.storeapi.domain.configuration;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter {
//
//    @Autowired
//    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1Pass"))
//                .authorities("ROLE_USER");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/securityNone")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//        http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//           httpSecurity.authorizeRequests()
//                   .antMatchers("/api/car/**").permitAll()
//                   .antMatchers("/api/car/brands").permitAll()
//                   .antMatchers("/api/car/models").permitAll()
//                   .antMatchers("/api/car/models/{brandName}").permitAll()
//                   .antMatchers("/api/car/models/{model}").permitAll()
//                   .antMatchers("/api/car/home").permitAll()
//                   .anyRequest().authenticated()
//                   .and()
//                   .formLogin()
//                   .loginPage("/api/car/login")
//                   .permitAll()
//                   .and()
//                   .logout()
//                   .permitAll();
//   }
}
