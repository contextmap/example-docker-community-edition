package com.webshop.shoppingcart.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {

    public static final String SHOPPING_CART_READ = "ROLE_SHOPPING_CART_READ";
    public static final String SHOPPING_CART_WRITE = "ROLE_SHOPPING_CART_WRITE";

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                PasswordEncoder passwordEncoder,
                                @Value("${credentials.application.admin.username}") String adminUsername,
                                @Value("${credentials.application.admin.password}") String adminPassword,
                                @Value("${credentials.application.guest.username}") String guestUsername,
                                @Value("${credentials.application.guest.password}") String guestPassword
    ) throws Exception {
        var inMemoryAuth = auth.inMemoryAuthentication();

        inMemoryAuth.withUser(adminUsername).password(passwordEncoder.encode(adminPassword)).authorities(SHOPPING_CART_READ, SHOPPING_CART_WRITE);
        inMemoryAuth.withUser(guestUsername).password(passwordEncoder.encode(guestPassword)).authorities(SHOPPING_CART_READ);
    }

    /**
     * Allow cross origin requests on all endpoints
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

