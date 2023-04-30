package com.example.noticias_v2;

import com.example.noticias_v2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    public UsuarioService usuarioServicio;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioServicio)
                .passwordEncoder(new BCryptPasswordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/*", "/js/*", "/img/*", "/inicio/*" ,"/inicio" ).permitAll()
              //  .antMatchers("/css/*", "/js/*", "/img/*", "/user", "/**").hasRole("USER")
             //   .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/").hasRole("USER")
                .and().formLogin()
                .loginPage("/inicio")
                .loginProcessingUrl("/loginCheck")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/entrada/index")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/inicio")
                .permitAll();
    }
//                .and().formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/logincheck")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/inicio")
//                .permitAll()
//                .and().logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .permitAll()
//                .and().csrf()
//                .disable();



}
