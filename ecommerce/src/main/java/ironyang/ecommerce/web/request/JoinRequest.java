package ironyang.ecommerce.web.request;

import ironyang.ecommerce.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinRequest {
    private String email;
    private String password;

    public UserDto toDto() {
        return UserDto.builder()
                .email(email)
                .password(password)
                .build();
    }
}
