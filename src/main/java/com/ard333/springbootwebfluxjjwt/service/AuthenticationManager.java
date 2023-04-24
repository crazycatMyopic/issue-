package com.ard333.springbootwebfluxjjwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class AuthenticationManager implements ReactiveAuthenticationManager {

    public AuthenticationManager() {
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.justOrEmpty(authentication.getCredentials().toString())
                .map(value -> {
                    return new UsernamePasswordAuthenticationToken(
                            "test",
                            null,
                            List.of(new SimpleGrantedAuthority("LOGIN")));
                });
    }
}
