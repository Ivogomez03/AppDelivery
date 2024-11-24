/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.service.ValidationMemory;
import java.lang.String;

/**
 *
 * @author Fran Balsamo
 */
public class ValidationController {
    ValidationMemory vmemory = new ValidationMemory();
    
    public boolean vendedorExists(String dni){
        return vmemory.vendedorExists(dni);
    }
}
