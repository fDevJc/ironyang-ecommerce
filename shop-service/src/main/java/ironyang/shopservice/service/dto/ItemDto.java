package ironyang.shopservice.service.dto;

import ironyang.shopservice.domain.Category;
import ironyang.shopservice.domain.Item;
import lombok.Builder;
import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;

    private Category category;
    private String sellerId;

    @Builder
    public ItemDto(Long id, String name, int price, int quantity, String categoryName, String sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = Category.valueOf(categoryName);
        this.sellerId = sellerId;
    }

    public static ItemDto of(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .categoryName(item.getCategory().name())
                .build();
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .category(category)
                .build();
    }
}
