package com.safeTravel.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.safeTravel.entity.Role;
import com.safeTravel.entity.User;
import com.safeTravel.payload.request.LoginRequest;
import com.safeTravel.payload.request.SignupRequest;
import com.safeTravel.payload.response.JwtResponse;
import com.safeTravel.payload.response.MessageResponse;
import com.safeTravel.repository.RoleRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.security.jwt.AuthEntryPointJwt;
import com.safeTravel.security.jwt.JwtUtils;
import com.safeTravel.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        logger.info("New user authanticate: " + loginRequest.getEmail());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        try {
            // Create new user's account
            User user = User.builder()
                    .firstname(signUpRequest.getFirstname())
                    .lastname(signUpRequest.getLastname())
                    .email(signUpRequest.getEmail())
                    .password(encoder.encode(signUpRequest.getPassword()))
                    .build();

            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));


            userRole.getUsers().add(user);

            userRepository.save(user);
            roleRepository.save(userRole);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Registration not valid!"));
        }

        logger.info("New user registred: " + signUpRequest.getEmail());
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}

