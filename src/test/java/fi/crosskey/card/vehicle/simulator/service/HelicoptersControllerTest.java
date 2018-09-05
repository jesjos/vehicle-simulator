package fi.crosskey.card.vehicle.simulator.service;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelicoptersControllerTest extends BaseControllerTest {

    @Test
    public void testPost() throws Exception {
        String inputJson = "{\"name\": \"foo\"}";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/helicopters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk());

        String expectedJson = "[{\"name\":\"foo\",\"currentState\":\"LANDED\"}]";
        mockMvc.perform(get("/helicopters")).andExpect(content().json(expectedJson));
    }
}