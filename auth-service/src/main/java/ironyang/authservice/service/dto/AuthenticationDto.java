package ironyang.authservice.service.dto;

import ironyang.authservice.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class AuthenticationDto {
    private String email;
    private String password;
    private String userType;
    private String role;

    @Builder
    public AuthenticationDto(String email, String password, String userType, String role) {
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.role = role;
    }

    public static AuthenticationDto of(User user) {
        return AuthenticationDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
