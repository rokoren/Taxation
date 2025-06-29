/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.exception;

/**
 *
 * @author Rok Koren
 */
public class TraderNotFoundException extends RuntimeException
{
    private final Long traderID;

    public TraderNotFoundException(Long traderID)
    {
        super("Trader with ID " + traderID + " not found.");        
        this.traderID = traderID;
    } 
    
    public Long getTraderID()
    {
        return traderID;
    }
}
