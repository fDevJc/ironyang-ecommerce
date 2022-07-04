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

    @Builder
    public ItemDto(Long id, String name, int price, int quantity, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = Category.valueOf(categoryName);
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
