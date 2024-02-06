package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import project.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEndcoder());
		return authenticationManagerBuilder.build();

	}

	@Bean(name = "passwordEndcoder")
	public PasswordEncoder passwordEndcoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/").permitAll()
						.requestMatchers("/home").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
						.requestMatchers("/createFaculty").hasAuthority("ROLE_ADMIN")
						.requestMatchers("/registrationFaculty").hasAuthority("ROLE_USER")
						.anyRequest().permitAll())

				.formLogin((form) -> form.loginPage("/login").usernameParameter("email").passwordParameter("password")
						.defaultSuccessUrl("/home"))

				.logout(form -> form.logoutSuccessUrl("/login?logout"))
				.exceptionHandling(e -> e.accessDeniedPage("/403")).authenticationManager(authenticationManager(http));

		return http.build();
	}
}
