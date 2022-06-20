package ironyang.ecommerce.service;

import ironyang.ecommerce.repository.UserRepository;
import ironyang.ecommerce.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void addUser(UserDto userDto) {
        userRepository.save(userDto.toEntity());
    }

    public UserDto findUser(Long id) {
        return UserDto.of(userRepository.findById(id).orElseThrow(()->new RuntimeException()));
    }
}
