package ironyang.authservice.repository;

import ironyang.authservice.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryAuthRepository implements AuthRepository {
    private static Map<String, User> store = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        User seller = User.builder()
                .id(1L)
                .email("seller@gmail.com")
                .password("seller")
                .role("ROLE_SELLER")
                .build();

        User buyer = User.builder()
                .id(2L)
                .email("buyer@gmail.com")
                .password("buyer")
                .role("ROLE_BUYER")
                .build();

        store.put(seller.getEmail(), seller);
        store.put(buyer.getEmail(), buyer);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(store.get(email));
    }

}
