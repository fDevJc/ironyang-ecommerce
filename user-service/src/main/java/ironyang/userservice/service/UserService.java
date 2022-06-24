package ironyang.userservice.service;

import ironyang.userservice.domain.User;
import ironyang.userservice.exception.NotFoundResourceException;
import ironyang.userservice.repository.UserRepository;
import ironyang.userservice.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long addUser(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getId();
    }

    public UserDto findUser(Long id) {
        return UserDto.of(
                userRepository.findById(id)
                        .orElseThrow(() -> new NotFoundResourceException(String.format("Not found Buyer id=%s", id)))
        );
    }
}
