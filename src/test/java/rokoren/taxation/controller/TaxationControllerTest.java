/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import rokoren.taxation.domain.Country;
import rokoren.taxation.domain.TaxationType;
import rokoren.taxation.domain.Trader;
import rokoren.taxation.repository.TraderRepository;

/**
 *
 * @author Rok Koren
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TaxationControllerTest 
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    //@BeforeEach
    public void setUp() 
    {
        // Vstavi testne podatke v H2 bazo (če ni že z import.sql)
        Country country = new Country();
        country.setId(100L);
        country.setName("Testland");
        country.setTaxationType(TaxationType.WINNINGS);
        country.setUseRate(true);
        country.setTax(0.1);

        Trader trader = new Trader();
        trader.setId(100L);
        trader.setName("Test Trader");
        trader.setCountry(country);

        traderRepository.save(trader);
    }    
    
    @Test
    public void taxation() throws Exception 
    {
        String requestJson = """
            {
              "traderId": 1,
              "playedAmount": 5,
              "odd": 1.5
            }
        """;

        mockMvc.perform(post("/rest/taxation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.possibleReturnAmountBefTax").value(7.5))
            .andExpect(jsonPath("$.taxAmount").value(0.25))
            .andExpect(jsonPath("$.possibleReturnAmount").value(7.25));
    }  
}
