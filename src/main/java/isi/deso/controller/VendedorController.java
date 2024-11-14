/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.VendedorDTO;
import isi.deso.service.VendedorMemory;
import isi.deso.tp.Paneles.PanelVendedor;
import isi.deso.tp.Paneles.SubPanelVendedorBuscar;
import isi.deso.tp.Paneles.SubPanelVendedorCrear;

/**
 *
 * @author ivogo
 */
public class VendedorController {
    private PanelVendedor panelVendedor;
    private SubPanelVendedorBuscar buscarPanel;
    private SubPanelVendedorCrear crearPanel;
    private VendedorDTO vendedorDTO;
    
    public VendedorController(){
        this.vendedorDTO = new VendedorDTO();
    }
    
    public VendedorController(PanelVendedor panelVendedor, SubPanelVendedorBuscar buscarPanel, SubPanelVendedorCrear crearPanel){
        this.panelVendedor = panelVendedor;
        this.buscarPanel = buscarPanel;
        this.crearPanel = crearPanel;
        this.vendedorDTO = new VendedorDTO();
        
        initListeners();
    }

    private void initListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void crearVendedor(String nombre, String apellido, String dni, String direccion, double latitud, double longitud){
        VendedorMemory vmemory = new VendedorMemory();
        
        vendedorDTO.setNombre(nombre);
        vendedorDTO.setApellido(apellido);
        vendedorDTO.setDni(dni);
        vendedorDTO.setDireccion(direccion);
        vendedorDTO.setLatitud(latitud);
        vendedorDTO.setLongitud(longitud);
        
        vmemory.agregarVendedor(vendedorDTO);
    }
}
