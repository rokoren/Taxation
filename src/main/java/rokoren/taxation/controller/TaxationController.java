/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rokoren.taxation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rokoren.taxation.dto.BetRequest;
import rokoren.taxation.dto.BetResponse;
import rokoren.taxation.service.TaxationService;

/**
 *
 * @author Rok Koren
 */
@RestController
@RequestMapping("rest/taxation")
public class TaxationController 
{
    private final TaxationService service;

    public TaxationController(TaxationService service) 
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BetResponse> taxation(@RequestBody BetRequest request) 
    {
        return ResponseEntity.ok(service.taxation(request));
    }    
}
