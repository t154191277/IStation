package bistu.wmlove.istation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bistu.wmlove.istation.security.UserDetailsServiceCustom;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceCustom customUserService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(customUserService).passwordEncoder(
				new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
//				.antMatchers(HttpMethod.POST).authenticated()
//				.antMatchers(HttpMethod.PUT).authenticated()
//				.antMatchers(HttpMethod.DELETE).authenticated()
//				.antMatchers("/api").permitAll().and().sessionManagement().and()
				.antMatchers("/**").permitAll().and().sessionManagement().and()
				.httpBasic();
	}

}
