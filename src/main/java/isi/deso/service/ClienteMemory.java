/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ClienteDAO;
import isi.deso.dto.ClienteDTO;
import isi.deso.model.Cliente;
import java.util.List;

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
            System.out.println("Ocurrio un error al intentar agregar el cliente");
            e.printStackTrace();
        }
            
    }
    
    public Cliente buscarCliente(String cuit) {
        
            Cliente cliente = clienteDAO.buscarCliente(cuit);
            
            if(cliente != null){
                System.out.println("Cliente con CUIT " + cliente.getCuit() + " encontrado");
                return cliente;
            } else {
                System.out.println("No se encontró el cliente.");
                return null;
            }
        
    }
    
    public void modificarCliente(ClienteDTO clienteDTO, int id){
        Cliente cliente = new Cliente(clienteDTO.getEmail(), clienteDTO.getCuit(), clienteDTO.getDireccion(),clienteDTO.getLatitud(),clienteDTO.getLongitud());
        cliente.setid(id);
        try{
            clienteDAO.modificarCliente(cliente);
            System.out.println("Se modificó de forma exitosa");
        }catch(RuntimeException e){
            System.out.println("Ocurrio un error al intentar modificar el cliente");
            e.printStackTrace();
        }
    }
    
    public void eliminarCliente(int id){
        try{
            clienteDAO.eliminarCliente(id);
            System.out.println("Se eliminó de forma exitosa");
        }catch(RuntimeException e){
            System.out.println("Ocurrio un error al intentar eliminar el cliente");
            e.printStackTrace();
        }
    }
    
    public List<Cliente> buscarTodosClientes(){
        List<Cliente> LCliente = clienteDAO.mostrarTodosClientes();
        
        if(!LCliente.isEmpty()){
            return LCliente;
        } else {
            return null;
        }
    }
}
