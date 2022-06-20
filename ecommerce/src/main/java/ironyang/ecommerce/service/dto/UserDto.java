package ironyang.ecommerce.service.dto;

import ironyang.ecommerce.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserDto {
    private String email;
    private String password;

    public static UserDto of(User user) {
        /*
        TODO: User Entity의 getter를 아예없앨 수 있을까??
         */
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
