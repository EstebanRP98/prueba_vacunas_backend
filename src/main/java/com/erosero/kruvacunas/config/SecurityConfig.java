package com.erosero.kruvacunas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
        .disable()
        .cors().and()
        .authorizeRequests()
        .antMatchers("/empleado/crearEmpleado", "/empleado/eliminarEmpleado",
                "/empleado/listarEmpleados", "/empleados/filtrarEmpleados").hasRole("ADMIN")
//                .antMatchers("/api/kruvacunas/**").
                .antMatchers("/empleado/actualizarEmpleado","/empleado/encontrarEmpleadoPorId", "/api/kruvacunas/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("javainuse")
//                .password(passwordEncoder().encode("javainuse"))
//                .authorities("ADMIN");
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
