package ironyang.shopservice.web;

import ironyang.shopservice.service.SellerService;
import ironyang.shopservice.web.request.SellerJoinRequest;
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
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("/sellers")
    public ResponseEntity join(@RequestBody SellerJoinRequest sellerJoinRequest) {
        sellerService.addSeller(sellerJoinRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
