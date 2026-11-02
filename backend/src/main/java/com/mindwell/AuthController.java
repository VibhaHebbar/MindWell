package com.mindwell;
import org.springframework.web.bind.annotation.*;import org.springframework.http.*;import org.springframework.security.crypto.password.PasswordEncoder;import jakarta.validation.Valid;import jakarta.validation.constraints.*;import java.util.Map;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final UserRepository users;private final PasswordEncoder encoder;private final JwtService jwt;
 public AuthController(UserRepository users,PasswordEncoder encoder,JwtService jwt){this.users=users;this.encoder=encoder;this.jwt=jwt;}
 public record RegisterRequest(@NotBlank @Size(max=80)String name,@NotBlank @Email @Size(max=254)String email,@NotBlank @Size(min=10,max=72)String password){}
 public record LoginRequest(@NotBlank @Email String email,@NotBlank String password){}
 @PostMapping("/register") public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest r){String email=r.email().trim().toLowerCase();if(users.existsByEmailIgnoreCase(email))return ResponseEntity.status(409).body(Map.of("message","An account with this email already exists."));User u=users.save(new User(r.name().trim(),email,encoder.encode(r.password())));return ResponseEntity.status(201).body(Map.of("token",jwt.create(u),"name",u.name,"email",u.email));}
 @PostMapping("/login") public ResponseEntity<?> login(@Valid @RequestBody LoginRequest r){User u=users.findByEmailIgnoreCase(r.email().trim()).orElse(null);if(u==null||!encoder.matches(r.password(),u.passwordHash))return ResponseEntity.status(401).body(Map.of("message","Email or password is incorrect."));return ResponseEntity.ok(Map.of("token",jwt.create(u),"name",u.name,"email",u.email));}
}
