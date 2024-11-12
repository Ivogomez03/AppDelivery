/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ClienteDAO;
import isi.deso.dto.ClienteDTO;
import isi.deso.model.Cliente;

/**
 *
 * @author ivogo
 */
public class ClienteMemory {
    private final ClienteDAO clienteDAO;
    
    public ClienteMemory(){
        this.clienteDAO = new ClienteDAO();
    }
    
    void agregarCliente(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO.getEmail(), clienteDTO.getCuit(), clienteDTO.getDireccion(), clienteDTO.getLatitud(), clienteDTO.getLongitud());
        
        clienteDAO.crearCliente(cliente);
    }
}
