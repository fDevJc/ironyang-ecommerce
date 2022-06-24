package ironyang.shopservice.acceptance;

import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.shopservice.web.request.SellerJoinRequest;
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
public class SellerAcceptanceTest {
    @Autowired
    MockMvc mvc;

    private static final String SHOP_SERVICE_URL = "/shop-service";

    @DisplayName("판매자가 회원가입을 한다")
    @Test
    void join() throws Exception {
        //given
        SellerJoinRequest content = SellerJoinRequest.builder()
                .email("seller@gmail.com")
                .password("password")
                .build();

        //when && then
        mvc.perform(post(SHOP_SERVICE_URL + "/sellers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(content)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
