package ironyang.userservice.web;

import ironyang.userservice.service.UserService;
import ironyang.userservice.web.request.UserJoinRequest;
import ironyang.userservice.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user-service")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/health-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("health!!");
    }

    @PostMapping("/users")
    public ResponseEntity<Long> join(@RequestBody UserJoinRequest userJoinRequest) {
        Long userId = userService.addUser(userJoinRequest.toDto());
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserResponse.of(userService.findUser(id)));
    }
}
