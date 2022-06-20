package ironyang.ecommerce.service;

import ironyang.ecommerce.exception.NotFoundItemException;
import ironyang.ecommerce.repository.ItemRepository;
import ironyang.ecommerce.service.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public void addItem(ItemDto itemDto) {
        itemRepository.save(itemDto.toEntity());
    }

    public ItemDto findItem(Long id) {
        return ItemDto.of(itemRepository.findById(id).orElseThrow(() -> new NotFoundItemException(String.format("Not found Item id=%s", id))));
    }
}
