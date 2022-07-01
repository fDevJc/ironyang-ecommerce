package ironyang.authservice.service;

import ironyang.authservice.repository.AuthRepository;
import ironyang.authservice.service.dto.AuthenticationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthenticationDto login(AuthenticationDto authenticationDto) {
        return AuthenticationDto.of(authRepository.findByEmail(authenticationDto.getEmail()).orElseThrow(()->new RuntimeException()));
    }
}
