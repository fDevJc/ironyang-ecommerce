package ironyang.userservice.acceptance;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.userservice.web.request.UserJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserAcceptanceTest {
    @Autowired
    MockMvc mvc;

    private static final String USER_SERVICE_URL = "/user-service";

    @DisplayName("사용자가 회원가입을 한다")
    @Test
    void join() throws Exception {
        UserJoinRequest userJoinRequest = UserJoinRequest.builder()
                .name("양지철")
                .email("fdevjc@gmail.com")
                .password("password")
                .build();

        //when && then
        mvc.perform(post(USER_SERVICE_URL + "/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userJoinRequest)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
