package com.ard333.springbootwebfluxjjwt.rest;

import com.ard333.springbootwebfluxjjwt.security.model.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@AllArgsConstructor
@RestController
public class AuthenticationREST {

//    private JWTUtil jwtUtil;
//    private PBKDF2Encoder passwordEncoder;
//    private UserService userService;

    @GetMapping("/login")
    @PreAuthorize("hasAuthority('LOGIN')")
    public Mono<ResponseEntity<Object>> login() {
//        return userService.findByUsername(ar.getUsername())
//            .filter(userDetails -> passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword()))
//            .map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
////            .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()))
//                ;
        return Mono.just(ResponseEntity.ok("HI"));
    }

}
