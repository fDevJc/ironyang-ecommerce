package ironyang.shopservice.service;

import ironyang.shopservice.repository.SellerRepository;
import ironyang.shopservice.service.dto.SellerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    @Transactional
    public void addSeller(SellerDto sellerDto) {
        sellerRepository.save(sellerDto.toEntity());
    }
}
