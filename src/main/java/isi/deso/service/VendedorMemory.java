package isi.deso.service;


import isi.deso.dao.VendedorDAO;
import isi.deso.dto.VendedorDTO;
import isi.deso.model.Vendedor;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivogo
 */
public class VendedorMemory {
    private final VendedorDAO vendedorDAO;
    
    public VendedorMemory(){
        this.vendedorDAO = new VendedorDAO();
    }
    
    public void agregarVendedor(VendedorDTO vendedorDTO){
        Vendedor vendedorNew = new Vendedor(vendedorDTO.getNombre(),vendedorDTO.getApellido(), vendedorDTO.getDireccion(),vendedorDTO.getDni(),vendedorDTO.getLatitud(),vendedorDTO.getLongitud(),vendedorDTO.getItems());
        
        try{
            vendedorDAO.crearVendedor(vendedorNew);
            System.out.println("Se agrego de forma exitosa");
        }catch(RuntimeException e){
            System.out.println("Ocurrio un error al intentar agregar el vededor");
            e.printStackTrace();
        }
    };
    public void listarVendedor(){};
    public void eliminarVendedor(){};
    public void actualizarVendedor(){};
    
    public Vendedor buscarVendedor(String dni){
        Vendedor vendedor = vendedorDAO.buscarVendedor(dni);
            
            if(vendedor != null){
                System.out.println("Vendedor con dni " + vendedor.getDni() + " encontrado");
                return vendedor;
            } else {
                System.out.println("No se encontró el vendedor.");
                return null;
            }
    
    }
    
    public List<Vendedor> buscarTodosVendedores(){
        List<Vendedor> LVendedor = vendedorDAO.mostrarTodosVendedores();
        
        if(!LVendedor.isEmpty()){
            return LVendedor;
        } else {
            return null;
        }
    }
}
