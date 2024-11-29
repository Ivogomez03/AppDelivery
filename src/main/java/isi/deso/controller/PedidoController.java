/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.model.Bebida;
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
    public List<Plato> obtenerPlatosSinTACC(String dniVendedor){
        return imemory.obtenerPlatosSinTACC(dniVendedor);
    }
    public Plato obtenerPlato(String nombre){
        return imemory.obtenerPlato(nombre);
    }
    public Bebida obtenerBebida(String nombre){
        return imemory.obtenerBebida(nombre);
    }
    public List<Bebida> obtenerBebidasConAlcohol(String dniVendedor){
        return imemory.obtenerBebidasConAlcohol(dniVendedor);
    }
    public List<Bebida> obtenerBebidasSinAlcohol(String dniVendedor){
        return imemory.obtenerBebidasSinAlcohol(dniVendedor);
    }
}
