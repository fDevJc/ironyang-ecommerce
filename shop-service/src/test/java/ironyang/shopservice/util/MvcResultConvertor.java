package ironyang.shopservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MvcResultConvertor {
    public static <T> List<T> convertToList(MvcResult result, Class<T> typeValue) throws JsonProcessingException, UnsupportedEncodingException {
        return new ObjectMapper().readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), new TypeReference<>() {
        });
    }

    public static <T> T convertToObj(MvcResult result, Class<T> valueType) throws UnsupportedEncodingException, JsonProcessingException {
        return new ObjectMapper().readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), valueType);
    }
}
