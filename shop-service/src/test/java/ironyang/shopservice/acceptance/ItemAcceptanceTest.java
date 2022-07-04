package ironyang.shopservice.acceptance;

import ironyang.shopservice.domain.Category;
import ironyang.shopservice.util.MvcResultConvertor;
import ironyang.shopservice.web.request.ItemRequest;
import ironyang.shopservice.web.response.ItemResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Rollback
public class ItemAcceptanceTest extends AcceptanceTest{
    private static final String ITEMS_REQUEST_URL = "/items";
    private static final String REQUEST_URL = SERVICE_NAME_URL + ITEMS_REQUEST_URL;

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
        mvc.perform(get(REQUEST_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(MvcResultConvertor.convertToList(result, ItemResponse.class).size()).isNotEqualTo(0))
                .andDo(print());
    }

    private ResultActions requestAddItem() throws Exception {
        ItemRequest itemRequest = ItemRequest.builder()
                .name("토마토")
                .price(10_000)
                .quantity(100)
                .categoryName(Category.FOOD.toString())
                .build();

        return mvc.perform(post(REQUEST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemRequest)));
    }
}
