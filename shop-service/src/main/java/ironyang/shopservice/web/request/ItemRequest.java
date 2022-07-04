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

    @Builder
    public ItemRequest(String name, int price, int quantity, String categoryName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
    }

    public ItemDto toDto() {
        return ItemDto.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .categoryName(categoryName)
                .build();
    }
}
