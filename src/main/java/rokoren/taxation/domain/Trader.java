/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Rok Koren
 */
@Entity
@Table(name="TRADER")
public class Trader 
{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(optional = false)
    private Country country;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }   
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }    
    
    public Country getCountry()
    {
        return country;
    }
    
    public void setCountry(Country country)
    {
        this.country = country;
    }
}
