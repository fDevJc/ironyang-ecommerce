package ironyang.shopservice.service;

import ironyang.shopservice.repository.ShopRepository;
import ironyang.shopservice.service.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public Long addShop(ShopDto shopDto) {
        return shopRepository.save(shopDto.toEntity()).getId();
    }
}
