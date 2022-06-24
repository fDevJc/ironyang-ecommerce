package ironyang.shopservice.service.dto;

import ironyang.shopservice.domain.Shop;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShopDto {
    private String businessNumber;
    private String name;
    private String address;
    private String phone;

    public Shop toEntity() {
        return Shop.builder()
                .businessNumber(businessNumber)
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }
}
