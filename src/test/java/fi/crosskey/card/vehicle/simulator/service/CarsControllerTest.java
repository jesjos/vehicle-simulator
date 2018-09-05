package fi.crosskey.card.vehicle.simulator.service;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CarsControllerTest extends BaseControllerTest {

    @Test
    public void testPost() throws Exception {
        String inputJson = "{\"name\": \"foo\"}";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk());

        String expectedJson = "[{\"name\":\"foo\",\"state\":\"STOPPED\"}]";
        mockMvc.perform(get("/cars")).andExpect(content().json(expectedJson));
    }
}
