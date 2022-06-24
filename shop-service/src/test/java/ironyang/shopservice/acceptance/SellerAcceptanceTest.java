package ironyang.shopservice.acceptance;

import ironyang.shopservice.web.request.SellerJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class SellerAcceptanceTest extends AcceptanceTest{
    private static final String ITEMS_REQUEST_URL = "/sellers";
    private static final String REQUEST_URL = SERVICE_NAME_URL + ITEMS_REQUEST_URL;

    @DisplayName("판매자가 회원가입을 한다")
    @Test
    void join() throws Exception {
        //given
        SellerJoinRequest content = SellerJoinRequest.builder()
                .email("seller@gmail.com")
                .password("password")
                .build();

        //when && then
        mvc.perform(post(REQUEST_URL)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(content)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @DisplayName("판매자의 세부정보를 등록합니다.")
    @Test
    void modifySeller() {
        //given

        //when

        //then
    }
}
