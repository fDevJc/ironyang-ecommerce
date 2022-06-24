package ironyang.shopservice.web.request;

import ironyang.shopservice.service.dto.SellerDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SellerJoinRequest {
    private String email;
    private String password;

    @Builder
    public SellerJoinRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SellerDto toDto() {
        return SellerDto.builder()
                .email(email)
                .password(password)
                .build();
    }
}
