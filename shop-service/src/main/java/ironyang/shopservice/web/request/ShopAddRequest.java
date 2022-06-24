package ironyang.shopservice.web.request;

import ironyang.shopservice.service.dto.ShopDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ShopAddRequest {
    private String businessNumber;
    private String name;
    private String address;
    private String phone;

    @Builder
    private ShopAddRequest(String businessNumber, String name, String address, String phone) {
        this.businessNumber = businessNumber;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public ShopDto toDto() {
        return ShopDto.builder()
                .businessNumber(businessNumber)
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }
}
