/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.model.Plato;
import isi.deso.service.ItemMenuMemory;
import isi.deso.service.PedidoMemory;
import java.util.List;

/**
 *
 * @author ivogo
 */
public class PedidoController {
    PedidoMemory pmemory = new PedidoMemory();
    ItemMenuMemory imemory = new ItemMenuMemory();
    
public List<Plato> obtenerPlatos(String dniVendedor){
        return imemory.obtenerPlatos(dniVendedor);
    }
}
