package ironyang.shopservice.web;

import ironyang.shopservice.service.ShopService;
import ironyang.shopservice.web.request.ShopAddRequest;
import ironyang.shopservice.web.response.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/shop-service")
@RestController
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shops")
    public ResponseEntity<ShopResponse> addShop(@RequestBody ShopAddRequest shopAddRequest) {
        Long shopId = shopService.addShop(shopAddRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).body(ShopResponse.builder().id(shopId).build());
    }
}
