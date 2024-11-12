/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.ClienteDTO;
import isi.deso.service.ClienteMemory;
import isi.deso.tp.Paneles.PanelCliente;
import isi.deso.tp.Paneles.SubPanelClienteBuscar;
import isi.deso.tp.Paneles.SubPanelClienteCrear;

/**
 *
 * @author ivogo
 */
public class ClienteController {
    private PanelCliente panelCliente;
    private SubPanelClienteBuscar buscarPanel;
    private SubPanelClienteCrear crearPanel;
    private ClienteDTO clienteDTO;
    
    public ClienteController(){
        this.clienteDTO = new ClienteDTO();
        }
    
    public ClienteController(PanelCliente panelCliente, SubPanelClienteBuscar buscarPanel, SubPanelClienteCrear crearPanel){
        this.panelCliente = panelCliente;
        this.buscarPanel = buscarPanel;
        this.crearPanel = crearPanel;
        this.clienteDTO = new ClienteDTO();
        
        initListeners();
    }

    private void initListeners() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void crearCliente(String direccion, String email, double latitud, double longitud, String CUIT){
        ClienteMemory cmemory = new ClienteMemory();
        
        clienteDTO.setDireccion(direccion);
        clienteDTO.setEmail(email);
        clienteDTO.setCUIT(CUIT);
        clienteDTO.setLatitud(latitud);
        clienteDTO.setLongitud(longitud);
        
        cmemory.agregarCliente(clienteDTO);
        
    }
}
