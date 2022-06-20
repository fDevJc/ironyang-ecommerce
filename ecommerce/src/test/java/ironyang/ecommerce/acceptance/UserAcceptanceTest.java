package ironyang.ecommerce.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.ecommerce.web.request.JoinRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserAcceptanceTest {
    @Autowired MockMvc mvc;

    @Test
    void join() throws Exception {
        JoinRequest joinRequest = new JoinRequest("fdevjc@gmail.com","password");
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(joinRequest);
        mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void findUser() throws Exception {
        //given
        JoinRequest joinRequest = new JoinRequest("fdevjc@gmail.com","password");
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(joinRequest);
        mvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isCreated())
                .andDo(print());
        //when
        mvc.perform(get("/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        //then
    }
}
