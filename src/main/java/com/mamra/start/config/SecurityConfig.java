//package com.mamra.start.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//private  final DataSource dataSource;
//
//@Bean
//public UserDetailsService userDetailsService(){
//    UserDetails userDetails = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("user1")
//            .roles("USER")
//            .build();
//    return new InMemoryUserDetailsManager(userDetails);
//}
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
////        auth.jdbcAuthentication()
////                .withDefaultSchema()
////                .dataSource((dataSource))
////        .withUser("test")
////        .password("{bcrypt" + new BCryptPasswordEncoder().encode("test"))
////        .roles("USER");
////    }
//
//    @Override
//    protected void configure(HttpSecurity http)throws  Exception{
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/swagger-ui.html").anonymous()
//                .antMatchers("/v2/api-docs").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("swagger-resources/**").permitAll()
//                .antMatchers("h2-console/**").permitAll()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//   //             .and()
//  //              .exceptionHandling()
//  //              .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
//    }
//}
