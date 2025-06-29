/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.service;

import org.springframework.stereotype.Service;
import rokoren.taxation.domain.Country;
import rokoren.taxation.domain.Country.TaxationType;
import rokoren.taxation.domain.Trader;
import rokoren.taxation.dto.BetRequest;
import rokoren.taxation.dto.BetResponse;
import rokoren.taxation.exception.TraderNotFoundException;
import rokoren.taxation.repository.TraderRepository;

/**
 *
 * @author Rok Koren
 */
@Service
public class TaxationService 
{
    private final TraderRepository traderRepository;

    public TaxationService(TraderRepository traderRepository) 
    {
        this.traderRepository = traderRepository;
    }

    public BetResponse taxation(BetRequest request) 
    {
        Trader trader = traderRepository.findById(request.traderId())
                .orElseThrow(() -> new TraderNotFoundException(request.traderId()));

        Country country = trader.getCountry();

        double playedAmount = request.playedAmount();
        double odd = request.odd();

        double possibleReturnAmountBefTax = playedAmount * odd;
        double possibleReturnAmount;
        double taxAmount;
        double taxRate = country.isUseRate() ? country.getValue() : 0;

        if (country.getTaxationType() == TaxationType.GENERAL) {
            double base = possibleReturnAmountBefTax;
            taxAmount = country.isUseRate()
                    ? base * country.getValue()
                    : country.getValue();
            possibleReturnAmount = possibleReturnAmountBefTax - taxAmount;
        } else if (country.getTaxationType() == TaxationType.WINNINGS) {
            double winnings = possibleReturnAmountBefTax - playedAmount;
            taxAmount = country.isUseRate()
                    ? winnings * country.getValue()
                    : country.getValue();
            possibleReturnAmount = possibleReturnAmountBefTax - taxAmount;
        } else {
            throw new IllegalStateException("Unknown taxation type for country: " + country.getName());
        }

        return new BetResponse(
                possibleReturnAmount,
                possibleReturnAmountBefTax,
                possibleReturnAmount,
                taxRate,
                taxAmount
        );
    }  
}
