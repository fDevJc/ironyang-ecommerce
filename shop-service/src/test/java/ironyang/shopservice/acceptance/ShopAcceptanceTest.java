package ironyang.shopservice.acceptance;

import ironyang.shopservice.util.MvcResultConvertor;
import ironyang.shopservice.web.request.ShopAddRequest;
import ironyang.shopservice.web.response.ShopResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ShopAcceptanceTest extends AcceptanceTest{
    private static final String SHOPS_REQUEST_URL = "/shops";
    private static final String REQUEST_URL = SERVICE_NAME_URL + SHOPS_REQUEST_URL;

    @DisplayName("가게를 등록한다")
    @Test
    void addShop() throws Exception {
        //given
        ShopAddRequest content = ShopAddRequest.builder()
                .name("shopName")
                .address("seoul")
                .businessNumber("1223123")
                .phone("123-123-123")
                .build();

        //when && then
        mvc.perform(post(REQUEST_URL)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(content)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(result -> assertThat(MvcResultConvertor.convertToObj(result, ShopResponse.class).getId()).isNotNull())
                .andDo(print());
    }
}
