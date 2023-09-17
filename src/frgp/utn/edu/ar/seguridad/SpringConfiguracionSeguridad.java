package frgp.utn.edu.ar.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/redireccionar_pagPantallaUbicacion.html").hasRole("ADMIN")
				.antMatchers("/redireccionar_pagArticulosListar.html").hasRole("ADMIN")
				.antMatchers("/redireccionar_pagArticulosAgregar.html").hasAnyRole("ADMIN", "USER").and().formLogin()
                .and()
                .logout() // Agregar esta configuración
                .logoutUrl("/logout.html") // URL del endpoint de logout
                .logoutSuccessUrl("/login") // Página de redirección después del logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable(); // Eliminar la cookie de sesión
		super.configure(http);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("123").roles("USER")
		.and()
		.withUser("grupo1").password("grupo1").roles("USER")
		.and()
		.withUser("grupo2").password("grupo2").roles("USER")
		.and()
		.withUser("grupo3").password("grupo3").roles("USER")
		.and()
		.withUser("grupo4").password("grupo4").roles("USER")
		.and()
		.withUser("grupo5").password("grupo5").roles("USER")
		.and()
		.withUser("grupo6").password("grupo6").roles("USER")
		.and()
		.withUser("grupo7").password("grupo7").roles("USER")
		.and()
		.withUser("grupo8").password("grupo8").roles("USER")
		.and()
		.withUser("grupo9").password("grupo9").roles("USER")
		.and()
		.withUser("grupo10").password("grupo10").roles("USER")
		.and()
		.withUser("grupo11").password("grupo11").roles("USER")
		.and()
		.withUser("grupo12").password("grupo12").roles("USER")
		.and()
		.withUser("grupo13").password("grupo13").roles("USER")
		.and()
		.withUser("grupo14").password("grupo14").roles("USER")
		.and()
		.withUser("grupo15").password("grupo15").roles("USER")
		.and()
		.withUser("grupo16").password("grupo16").roles("USER")
		.and()
		.withUser("grupo17").password("grupo17").roles("USER")
		.and()
		.withUser("grupo18").password("grupo18").roles("USER")
		.and()
		.withUser("grupo19").password("grupo19").roles("USER")
		.and()
		.withUser("grupo20").password("grupo20").roles("USER")
		.and()
		.withUser("admin").password("123").roles("ADMIN");
	}

}