package dev.siqueira.financecontrol_sb.Controller;

import dev.siqueira.financecontrol_sb.Dto.AuthDTO;
import dev.siqueira.financecontrol_sb.Dto.JwtResponseDTO;
import dev.siqueira.financecontrol_sb.Entity.UserModel;
import dev.siqueira.financecontrol_sb.Repository.UserRepository;
import dev.siqueira.financecontrol_sb.Service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService authenticationService, UserRepository userRepository, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO loginRequest) {
        Authentication authentication = (new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        String token = authenticationService.authenticate(authentication);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthDTO authDto) {
        if (this.userRepository.findByUsername(authDto.username()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(authDto.password());
        UserModel userModel = new UserModel(authDto.username(), encryptedPassword, LocalDateTime.now(), LocalDateTime.now());

        this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully: " + userModel.getUsername());
    }
}
