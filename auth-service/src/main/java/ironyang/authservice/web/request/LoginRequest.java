package ironyang.authservice.web.request;

import ironyang.authservice.service.dto.AuthenticationDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class LoginRequest {
    private String email;
    private String password;

    @Builder
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationDto toAuthenticationDto() {
        return AuthenticationDto.builder()
                .email(email)
                .password(password)
                .build();
    }
}
