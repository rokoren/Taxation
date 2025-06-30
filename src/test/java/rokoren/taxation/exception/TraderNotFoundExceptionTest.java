/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author Rok Koren
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TraderNotFoundExceptionTest 
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returns404WhenTraderNotFound() throws Exception {
        String requestJson = """
            {
              "traderId": 9999,
              "playedAmount": 5,
              "odd": 1.5
            }
        """;

        mockMvc.perform(post("/rest/taxation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isNotFound())
            .andExpect(content().string("Trader with ID 9999 not found."));
    }    
}
