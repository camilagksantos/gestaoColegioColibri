package pt.colegio.colibri.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pt.colegio.colibri.business.service.UserDetailsServiceImpl;

//@Configuration: Indica que esta classe é usada para definir beans e outras configurações do Spring.
//@EnableWebSecurity: Habilita o suporte do Spring Security no aplicativo.
//@EnableMethodSecurity: Habilita a segurança de métodos, permitindo que você aplique segurança a métodos específicos em
// suas classes.
//@RequiredArgsConstructor: Uma anotação do Lombok que gera automaticamente um construtor que requer argumentos para
// todos os campos finais (neste caso, UserDetailsServiceImpl userDetailsService). Isso é útil para injetar dependências.

//http.authorizeHttpRequests(config -> config.anyRequest().authenticated()); configura todas as requisições para
// exigir autenticação.

//Este código é um exemplo de como configurar a segurança básica em um aplicativo Spring Boot, incluindo a desativação
// do CSRF, a exigência de autenticação para todas as requisições, e a utilização de um PasswordEncoder para lidar com
// a codificação de senhas.

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain mySecurityFilterChain( HttpSecurity http ) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests( config ->
                config.anyRequest().authenticated());

        http.userDetailsService( userDetailsService );

        http.httpBasic();

        return http.build();
    }

    // Usando pass code text
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //  Usando ByCripyt
    //	@Bean
    //	PasswordEncoder passwordEncoder(){
    //		return new BCryptPasswordEncoder();
    //	}
}
