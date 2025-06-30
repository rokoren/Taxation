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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaxationType taxationType;

    private boolean useRate; // true = rate, false = fixed amount

    private double tax; // either rate or fixed amount 
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }    
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public TaxationType getTaxationType()
    {
        return taxationType;
    }
    
    public void setTaxationType(TaxationType taxationType)
    {
        this.taxationType = taxationType;
    }
    
    public boolean isUseRate()
    {
        return useRate;
    }
    
    public void setUseRate(boolean useRate)
    {
        this.useRate = useRate;
    }
    
    public double getTax()
    {
        return tax;
    }
    
    public void setTax(double tax)
    {
        this.tax = tax;
    }
}
