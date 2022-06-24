package ironyang.shopservice.service;

import ironyang.shopservice.domain.Item;
import ironyang.shopservice.domain.Seller;
import ironyang.shopservice.exception.NotFoundResourceException;
import ironyang.shopservice.repository.ItemRepository;
import ironyang.shopservice.service.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void addItem(ItemDto itemDto) {
        log.info("itemDto.getSellerId() = {}", itemDto.getSellerId());
        Item item = Item.builder()
                .name(itemDto.getName())
                .quantity(itemDto.getQuantity())
                .price(itemDto.getPrice())
//                .shop()
                .category(itemDto.getCategory())
                .build();
        itemRepository.save(item);
    }

    public ItemDto findItem(Long id) {
        return ItemDto.of(itemRepository.findById(id).orElseThrow(() -> new NotFoundResourceException(String.format("Not found Item id=%s", id))));
    }

    public List<ItemDto> findItems() {
        return itemRepository.findAll().stream()
                .map(ItemDto::of)
                .collect(Collectors.toList());
    }
}
