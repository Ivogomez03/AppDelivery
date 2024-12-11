/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.VendedorDTO;
import isi.deso.model.Vendedor;
import isi.deso.service.VendedorMemory;
import isi.deso.tp.Paneles.PanelVendedor;
import isi.deso.tp.Paneles.SubPanelVendedorBuscar;
import isi.deso.tp.Paneles.SubPanelVendedorCrear;
import java.util.List;

/**
 *
 * @author ivogo
 */
public class VendedorController {
   
    private VendedorDTO vendedorDTO;
    private VendedorMemory vmemory;
    
    public VendedorController(){
        this.vendedorDTO = new VendedorDTO();
        this.vmemory = new VendedorMemory();
    }
    
    public VendedorController(PanelVendedor panelVendedor, SubPanelVendedorBuscar buscarPanel, SubPanelVendedorCrear crearPanel){
        this.vendedorDTO = new VendedorDTO();
    }
    
    public void crearVendedor(String nombre, String apellido, String dni, String direccion, double latitud, double longitud){
        
        vendedorDTO.setNombre(nombre);
        vendedorDTO.setApellido(apellido);
        vendedorDTO.setDni(dni);
        vendedorDTO.setDireccion(direccion);
        vendedorDTO.setLatitud(latitud);
        vendedorDTO.setLongitud(longitud);
        
        vmemory.agregarVendedor(vendedorDTO);
    }
    
    public void modificarVendedor(int id, String nombre, String apellido, String dni, String direccion, double latitud, double longitud){
        vendedorDTO.setNombre(nombre);
        vendedorDTO.setApellido(apellido);
        vendedorDTO.setDni(dni);
        vendedorDTO.setDireccion(direccion);
        vendedorDTO.setLatitud(latitud);
        vendedorDTO.setLongitud(longitud);
        
        vmemory.actualizarVendedor(vendedorDTO, id);
    }
    
    public Vendedor buscarVendedor(String dni){
        return vmemory.buscarVendedor(dni);
    }
    
    public void eliminarVendedor(int id){
        vmemory.eliminarVendedor(id);
    }
    
    public List<Vendedor> mostrarTodosVendedores(){
        return vmemory.buscarTodosVendedores();
    }
}
