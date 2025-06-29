/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.dto;

/**
 *
 * @author Rok Koren
 */
public record BetResponse(
    double possibleReturnAmount,
    double possibleReturnAmountBefTax,
    double possibleReturnAmountAfterTax,
    double taxRate,
    double taxAmount
) {}
