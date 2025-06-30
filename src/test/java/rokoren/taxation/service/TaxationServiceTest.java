/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.service;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import rokoren.taxation.domain.Country;
import rokoren.taxation.domain.TaxationType;
import rokoren.taxation.domain.Trader;
import rokoren.taxation.dto.BetRequest;
import rokoren.taxation.dto.BetResponse;
import rokoren.taxation.repository.TraderRepository;

/**
 *
 * @author Rok Koren
 */
@ExtendWith(MockitoExtension.class)
public class TaxationServiceTest 
{
    @Mock
    private TraderRepository traderRepository;

    @InjectMocks
    private TaxationService taxationService;  
    
    @Test
    public void taxationWinningsPerRate() 
    {
        Country country = new Country();
        country.setTaxationType(TaxationType.WINNINGS);
        country.setUseRate(true);
        country.setTax(0.1); // 10%

        Trader trader = new Trader();
        trader.setId(1L);
        trader.setCountry(country);

        when(traderRepository.findById(1L)).thenReturn(Optional.of(trader));

        BetRequest request = new BetRequest(1L, 5.0, 1.5);
        BetResponse response = taxationService.taxation(request);

        assertEquals(7.5, response.possibleReturnAmountBefTax(), 0.001);
        assertEquals(7.5 - 0.25, response.possibleReturnAmount(), 0.001); // 2.5 * 0.1
        assertEquals(0.1, response.taxRate(), 0.001);
        assertEquals(0.25, response.taxAmount(), 0.001);
    }  
    
    @Test
    public void taxationWinningsPerAmount() 
    {
        Country country = new Country();
        country.setTaxationType(TaxationType.WINNINGS);
        country.setUseRate(false);
        country.setTax(1.0); // fixed 1 EUR tax

        Trader trader = new Trader();
        trader.setId(2L);
        trader.setCountry(country);

        when(traderRepository.findById(2L)).thenReturn(Optional.of(trader));

        BetRequest request = new BetRequest(2L, 5.0, 1.5);
        BetResponse response = taxationService.taxation(request);

        assertEquals(7.5, response.possibleReturnAmountBefTax(), 0.001);
        assertEquals(7.5 - 1.0, response.possibleReturnAmount(), 0.001);
        assertEquals(0.0, response.taxRate(), 0.001);
        assertEquals(1.0, response.taxAmount(), 0.001);
    }  
    
    @Test
    public void taxationGeneralPerRate() 
    {
        Country country = new Country();
        country.setTaxationType(TaxationType.GENERAL);
        country.setUseRate(true);
        country.setTax(0.2); // 20%

        Trader trader = new Trader();
        trader.setId(3L);
        trader.setCountry(country);

        when(traderRepository.findById(3L)).thenReturn(Optional.of(trader));

        BetRequest request = new BetRequest(3L, 5.0, 1.5);
        BetResponse response = taxationService.taxation(request);

        assertEquals(7.5, response.possibleReturnAmountBefTax(), 0.001);
        assertEquals(7.5 - 1.5, response.possibleReturnAmount(), 0.001); // 7.5 * 0.2
        assertEquals(0.2, response.taxRate(), 0.001);
        assertEquals(1.5, response.taxAmount(), 0.001);
    }  
    
    @Test
    public void taxationGeneralPerAmount() 
    {
        Country country = new Country();
        country.setTaxationType(TaxationType.GENERAL);
        country.setUseRate(false);
        country.setTax(2.0); // fixed 2 EUR tax

        Trader trader = new Trader();
        trader.setId(4L);
        trader.setCountry(country);

        when(traderRepository.findById(4L)).thenReturn(Optional.of(trader));

        BetRequest request = new BetRequest(4L, 5.0, 1.5);
        BetResponse response = taxationService.taxation(request);

        assertEquals(7.5, response.possibleReturnAmountBefTax(), 0.001);
        assertEquals(7.5 - 2.0, response.possibleReturnAmount(), 0.001);
        assertEquals(0.0, response.taxRate(), 0.001);
        assertEquals(2.0, response.taxAmount(), 0.001);
    }     
}
