package ironyang.ecommerce.web;

import ironyang.ecommerce.service.ItemService;
import ironyang.ecommerce.service.dto.ItemDto;
import ironyang.ecommerce.web.request.ItemRequest;
import ironyang.ecommerce.web.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity addItem(@RequestBody ItemRequest itemRequest) {
        itemService.addItem(itemRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemResponse> findItem(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ItemResponse.of(itemService.findItem(id)));
    }
}
