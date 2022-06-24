package ironyang.shopservice.web.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopResponse {
    private Long id;

    @Builder
    private ShopResponse(Long id) {
        this.id = id;
    }
}
