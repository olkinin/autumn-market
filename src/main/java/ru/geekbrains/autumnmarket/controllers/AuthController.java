package ru.geekbrains.autumnmarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.autumnmarket.entity.AuthRequest;
import ru.geekbrains.autumnmarket.entity.AuthResponse;
import ru.geekbrains.autumnmarket.exeption.MarketError;
import ru.geekbrains.autumnmarket.service.UserService;
import ru.geekbrains.autumnmarket.utils.JwtTokenUtil;

//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final UserService userService;
//    private final JwtTokenUtil jwtTokenUtil;
//    private final AuthenticationManager authenticationManager;
//
//    @PostMapping("/auth")
//    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
//        } catch (BadCredentialsException ex) {
//            return new ResponseEntity<>(new MarketError("Incorrect username or password"), HttpStatus.UNAUTHORIZED);
//        }
//        UserDetails userDetails = userService.loadUserByUsername(authRequest.getName());
//        String token = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthResponse(token));
//    }
//}
