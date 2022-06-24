package ironyang.shopservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/shop-service")
@RestController
public class HomeController {
    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }
}
