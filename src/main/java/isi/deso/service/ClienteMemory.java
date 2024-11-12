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
public class ClienteMemory{
    private final ClienteDAO clienteDAO;
    
    public ClienteMemory(){
        this.clienteDAO = new ClienteDAO();
    }
    
    public void agregarCliente(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO.getEmail(), clienteDTO.getCuit(), clienteDTO.getDireccion(), clienteDTO.getLatitud(), clienteDTO.getLongitud());
        
        
        try{
            clienteDAO.crearCliente(cliente);
            System.out.println("Se agrego de forma exitosa");
        }
        catch(RuntimeException e){
            if(e.getMessage().contains("El cliente ya existe")){
                System.out.println("No se pudo agregar: El cliente ya existe");
            }else{
                System.out.println("Ocurrio un error al intentar agregar el cliente");
            }
            e.printStackTrace();
        }
            
    }
}
