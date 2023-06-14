package se.onlyfin.onlyfin2backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.onlyfin.onlyfin2backend.repository.UserRepository;

import java.security.Principal;

@RequestMapping("/user")
@Controller
@CrossOrigin(origins = {"localhost:3000"}, allowCredentials = "true")
public class DeleteThisLaterController {
    private final UserRepository userRepository;

    public DeleteThisLaterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/name")
    public ResponseEntity<String> username(Principal principal) {
        String username = principal.getName();

        return ResponseEntity.ok().body(username);
    }

}
