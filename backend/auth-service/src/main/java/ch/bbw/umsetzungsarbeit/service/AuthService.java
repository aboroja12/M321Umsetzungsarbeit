package ch.bbw.umsetzungsarbeit.service;

import ch.bbw.umsetzungsarbeit.dto.LoginRequest;
import ch.bbw.umsetzungsarbeit.dto.RegisterRequest;
import ch.bbw.umsetzungsarbeit.model.User;
import ch.bbw.umsetzungsarbeit.repository.UserRepository;
import ch.bbw.umsetzungsarbeit.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
  }

  public void register(RegisterRequest registerRequest) {
    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setRole("USER");
    userRepository.save(user);
  }

  public String login(LoginRequest loginRequest) {
    User user = userRepository.findByUsername(loginRequest.getUsername())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }

    return jwtUtil.generateToken(user.getUsername());
  }
}
