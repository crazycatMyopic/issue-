package com.ard333.springbootwebfluxjjwt.service;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class WebFilter implements ServerAuthenticationConverter {
    private static final String auth = "Bearer";

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                .filter(token -> (token.startsWith(auth)))
                .map(valid -> new UsernamePasswordAuthenticationToken(valid.replaceFirst(auth, "").trim(), valid.replaceFirst(auth, "").trim()))
                ;
    }
}
