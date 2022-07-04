package ironyang.shopservice.web;

import ironyang.shopservice.service.ItemService;
import ironyang.shopservice.web.request.ItemRequest;
import ironyang.shopservice.web.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/shop/{shopId}/items")
    public ResponseEntity addItem(@RequestBody ItemRequest itemRequest, @PathVariable(name = "shopId") Long shopId) {
        log.info("ItemController.addItem() shopId = {}", shopId);
        itemService.addItem(itemRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemResponse> findItem(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ItemResponse.of(itemService.findItem(id)));
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemResponse>> findItems() {
        return ResponseEntity.status(HttpStatus.OK).body(
                itemService.findItems().stream()
                        .map(ItemResponse::of)
                        .collect(Collectors.toList())
        );
    }
}
