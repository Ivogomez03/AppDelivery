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
    private final ValidatorMemory validator;
    
    public VendedorMemory(){
        this.vendedorDAO = new VendedorDAO();
        this.validator = new ValidatorMemory();
    }
    
    public void crearVendedor(VendedorDTO vendedorDTO){
        Vendedor vendedorNew = new Vendedor(vendedorDTO.getId(),vendedorDTO.getNombre(),vendedorDTO.getDireccion(),vendedorDTO.getDni(),vendedorDTO.getLatitud(),vendedorDTO.getLongitud(),vendedorDTO.getItems());
        this.validator.uniquenessValidationVendedor(vendedorDTO);
        
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
    public void buscarVendedor(){};
}
