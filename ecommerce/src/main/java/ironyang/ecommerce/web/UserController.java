package ironyang.ecommerce.web;

import ironyang.ecommerce.service.UserService;
import ironyang.ecommerce.service.dto.UserDto;
import ironyang.ecommerce.web.request.JoinRequest;
import ironyang.ecommerce.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity join(@RequestBody JoinRequest joinRequest) {
        log.info("UserController.join().joinRequest={}", joinRequest);
        userService.addUser(joinRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable("id") Long id) {
        UserDto userDto = userService.findUser(id);
        UserResponse userResponse = UserResponse.of(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
