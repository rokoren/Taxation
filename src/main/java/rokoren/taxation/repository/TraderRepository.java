/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rokoren.taxation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rokoren.taxation.domain.Trader;

/**
 *
 * @author Rok Koren
 */
public interface TraderRepository extends JpaRepository<Trader, Long>
{    
}
