package ironyang.ecommerce.web.request;

import ironyang.ecommerce.service.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemRequest {
    private String name;
    private int price;
    private int quantity;

    public ItemDto toDto() {
        return ItemDto.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
