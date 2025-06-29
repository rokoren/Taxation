/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Rok Koren
 */
@Entity
@Table(name="COUNTRY")
public class Country 
{
    public enum TaxationType 
    {
        GENERAL,
        WINNINGS      
    }     
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaxationType taxationType;

    private boolean useRate; // true = rate, false = fixed amount

    private double value; // either rate or fixed amount 
    
    public String getName()
    {
        return name;
    }
    
    public TaxationType getTaxationType()
    {
        return taxationType;
    }
    
    public boolean isUseRate()
    {
        return useRate;
    }
    
    public double getValue()
    {
        return value;
    }
}
