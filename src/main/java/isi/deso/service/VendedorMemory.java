package isi.deso.service;


import isi.deso.dao.VendedorDAO;
import isi.deso.dto.VendedorDTO;
import isi.deso.model.Vendedor;
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
    
    public void crearVendedor(VendedorDTO vendedorDTO){
        Vendedor vendedorNew = new Vendedor(vendedorDTO.getId(),vendedorDTO.getNombre(),vendedorDTO.getDireccion(),vendedorDTO.getLatitud(),vendedorDTO.getLongitud(),vendedorDTO.getItems());
        
        try{
            vendedorDAO.crearVendedor(vendedorNew);
            System.out.println("Se agrego de forma exitosa");
        }catch(RuntimeException e){
            if(e.getMessage().contains("El vendedor ya existe")){
                System.out.println("No se pudo agregar: El vendedor ya existe");
            }else{
                System.out.println("Ocurrio un error al intentar agregar el vededor");
            }
            e.printStackTrace();
        }
    };
    public void listarVendedor(){};
    public void eliminarVendedor(){};
    public void actualizarVendedor(){};
    public void buscarVendedor(){};
}
