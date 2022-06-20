package ironyang.ecommerce.web.response;

import ironyang.ecommerce.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserResponse {
    private String email;

    public static UserResponse of(UserDto userDto) {
        return UserResponse.builder()
                .email(userDto.getEmail())
                .build();
    }
}
