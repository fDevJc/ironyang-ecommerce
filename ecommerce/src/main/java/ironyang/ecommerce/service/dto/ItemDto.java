package ironyang.ecommerce.service.dto;

import ironyang.ecommerce.domain.Item;
import lombok.Builder;
import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;

    @Builder
    public ItemDto(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
