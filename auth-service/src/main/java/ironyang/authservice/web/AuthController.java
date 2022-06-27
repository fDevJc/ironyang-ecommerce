package ironyang.authservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth-service")
@RestController
public class AuthController {

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }

    @PostMapping("/seller-login")
    public ResponseEntity sellerLogin() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user-login")
    public ResponseEntity userLogin() {
        return ResponseEntity.ok().build();
    }
}
