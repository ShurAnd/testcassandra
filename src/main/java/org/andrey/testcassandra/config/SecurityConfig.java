package org.andrey.testcassandra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        SecurityFilterChain chain = http.csrf(c -> c.disable())
                .cors(c -> c.disable())
                .authorizeHttpRequests(c -> {
                    c.anyRequest()
                            .permitAll();
                }).build();

        return chain;
    }
}
