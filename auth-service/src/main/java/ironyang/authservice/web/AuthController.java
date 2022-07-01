package ironyang.authservice.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import ironyang.authservice.service.AuthService;
import ironyang.authservice.service.dto.AuthenticationDto;
import ironyang.authservice.web.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RequiredArgsConstructor
@RequestMapping("/auth-service")
@RestController
public class AuthController {
    private final AuthService authService;

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        AuthenticationDto authenticationDto = authService.login(loginRequest.toAuthenticationDto());

        String jwtToken = JWT.create()
                .withSubject(authenticationDto.getEmail())    //토큰이름
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000*10)))   //만료기간(10분)
                .withClaim("email", authenticationDto.getEmail())   //
                .withClaim("role", authenticationDto.getRole())
                .sign(Algorithm.HMAC512("jc"));

        response.addHeader("Authorization", "Bearer " + jwtToken);
        return ResponseEntity.ok().build();
    }
}
