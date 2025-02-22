package ch.bbw.umsetzungsarbeit.controller;

import ch.bbw.umsetzungsarbeit.dto.LoginRequest;
import ch.bbw.umsetzungsarbeit.dto.RegisterRequest;
import ch.bbw.umsetzungsarbeit.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
    authService.register(registerRequest);
    return ResponseEntity.ok("User registered successfully");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    String token = authService.login(loginRequest);
    return ResponseEntity.ok(token);
  }
}