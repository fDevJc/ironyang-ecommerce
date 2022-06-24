package ironyang.shopservice.service.dto;

import ironyang.shopservice.domain.Seller;
import lombok.Builder;

public class SellerDto {
    private String email;
    private String password;

    @Builder
    public SellerDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static SellerDto of(Seller seller) {
        return SellerDto.builder()
                .email(seller.getEmail())
                .password(seller.getPassword())
                .build();
    }

    public Seller toEntity() {
        return Seller.builder()
                .email(email)
                .password(password)
                .build();
    }

}
