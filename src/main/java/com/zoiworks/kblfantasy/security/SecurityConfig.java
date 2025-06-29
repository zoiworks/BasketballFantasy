package com.zoiworks.kblfantasy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(auth -> auth
            // Ελεύθερη πρόσβαση σε login, signup και static αρχεία
            .requestMatchers("/login", "/signup", "/css/**", "/js/**", "/images/**").permitAll()
    
            // Μόνο για ADMIN KAI MANAGER
            .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
    
            // Μόνο για USER (αν θέλεις να επιτρέπεται και στους ADMIN, δες πιο κάτω)
            .requestMatchers("/profile", "/user/**").hasAnyRole("USER", "ADMIN")
    
            // Οτιδήποτε άλλο απαιτεί authentication
            .anyRequest().authenticated()
        )
    
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
