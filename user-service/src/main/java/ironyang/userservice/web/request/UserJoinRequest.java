package ironyang.userservice.web.request;

import ironyang.userservice.service.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.objenesis.SpringObjenesis;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJoinRequest {
    private String name;
    private String email;
    private String password;

    @Builder
    private UserJoinRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
