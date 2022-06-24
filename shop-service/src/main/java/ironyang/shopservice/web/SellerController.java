package ironyang.shopservice.web;

import ironyang.shopservice.service.SellerService;
import ironyang.shopservice.web.request.SellerJoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/shop-service")
@RestController
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }

    @PostMapping("/sellers")
    public ResponseEntity join(@RequestBody SellerJoinRequest sellerJoinRequest) {
        sellerService.addSeller(sellerJoinRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
