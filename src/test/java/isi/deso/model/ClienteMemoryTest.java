/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;

import isi.deso.service.ClienteMemory;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */

public class ClienteMemoryTest {
    ClienteMemory cmemory = new ClienteMemory();
    
    @Test
    public void buscarCliente(){
        String cuit = "123123123";
        
        Cliente cliente = cmemory.buscarCliente(cuit);
        
        if(cliente == null){
            System.out.println("Null");
        } else{
          cliente.println();
        }
    }
}
