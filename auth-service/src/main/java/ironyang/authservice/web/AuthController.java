package ironyang.authservice.web;

import ironyang.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth-service")
@RestController
public class AuthController {
    private final AuthService authService;

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }
}
