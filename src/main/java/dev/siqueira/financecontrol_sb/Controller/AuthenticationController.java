package dev.siqueira.financecontrol_sb.Controller;

import dev.siqueira.financecontrol_sb.Dto.AuthDto;
import dev.siqueira.financecontrol_sb.Entity.UserModel;
import dev.siqueira.financecontrol_sb.Repository.UserRepository;
import dev.siqueira.financecontrol_sb.Service.AuthenticationService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    public AuthenticationController(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthDto authDto) {
        if (this.userRepository.findByUsername(authDto.username()).isPresent()){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(authDto.password());
        UserModel userModel = new UserModel(authDto.username(), encryptedPassword, LocalDateTime.now(), LocalDateTime.now());

        this.userRepository.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully: " + userModel.getUsername());
    }
}
