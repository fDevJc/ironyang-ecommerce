package ironyang.shopservice.web.request;

import ironyang.shopservice.service.dto.ItemDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemRequest {
    private String name;
    private int price;
    private int quantity;

    private String categoryName;
    private String sellerId;

    @Builder
    public ItemRequest(String name, int price, int quantity, String categoryName, String sellerId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.sellerId = sellerId;
    }

    public ItemDto toDto() {
        return ItemDto.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .categoryName(categoryName)
                .sellerId(sellerId)
                .build();
    }
}
