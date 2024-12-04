/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.ItemsPedidoDTO;
import isi.deso.dto.PedidoDTO;
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
    PedidoDTO pedidoDTO = new PedidoDTO();
    
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
    
    public void CrearPedido(String cuitCliente, String dniVendedor, String pago, List<ItemsPedidoDTO> listaItems, double monto, String credenciales){
        pedidoDTO.setCuitCliente(cuitCliente);
        pedidoDTO.setDniVendedor(dniVendedor);
        pedidoDTO.setPago(pago);
        pedidoDTO.setDetalle(listaItems);
        pedidoDTO.setMontoPago(monto);
        pedidoDTO.setCredenciales(credenciales);
        
        pmemory.crearPedido(pedidoDTO);
    }
}
