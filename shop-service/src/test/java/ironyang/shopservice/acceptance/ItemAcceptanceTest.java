package ironyang.shopservice.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ironyang.shopservice.domain.Category;
import ironyang.shopservice.web.request.ItemRequest;
import ironyang.shopservice.web.response.ItemResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ItemAcceptanceTest {
    private static final String ITEMS_REQUEST_URL = "/items";
    @Autowired
    MockMvc mvc;

    @DisplayName("아이템을 등록한다")
    @Test
    void addItem() throws Exception {
        //given
        requestAddItem()
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @DisplayName("전체 아이템을 조회한다")
    @Test
    void findItems() throws Exception{
        //given
        requestAddItem();
        //when && then
        mvc.perform(get(ITEMS_REQUEST_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(result ->
                        {
                            List<ItemResponse> itemResponses = new JsonConvertor<ItemResponse>().convertToList(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
                            Assertions.assertThat(itemResponses.size()).isEqualTo(1);
                        }
                )
                .andDo(print());
    }

    private ResultActions requestAddItem() throws Exception {
        ItemRequest itemRequest = ItemRequest.builder()
                .name("토마토")
                .price(10_000)
                .quantity(100)
                .categoryName(Category.FOOD.toString())
                .sellerId("1")
                .build();

        return mvc.perform(post(ITEMS_REQUEST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(itemRequest)));
    }

    public static class JsonConvertor<T> {
        public List<T> convertToList(String json) throws JsonProcessingException {
            return new ObjectMapper().readValue(json, new TypeReference<>() {
            });
        }
    }
}
