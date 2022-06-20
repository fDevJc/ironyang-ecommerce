package ironyang.ecommerce.web.response;

import ironyang.ecommerce.service.dto.ItemDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemResponse {
    private Long id;
    private String name;
    private int price;
    private int quantity;

    @Builder
    public ItemResponse(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ItemResponse of(ItemDto itemDto) {
        return ItemResponse.builder()
                .id(itemDto.getId())
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .quantity(itemDto.getQuantity())
                .build();
    }
}
