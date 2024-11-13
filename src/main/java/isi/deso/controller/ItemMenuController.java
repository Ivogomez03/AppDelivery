/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.ItemMenuDTO;
import isi.deso.service.ItemMenuMemory;

/**
 *
 * @author ivogo
 */
public class ItemMenuController {
    private ItemMenuDTO itemMenuDTO;
    private ItemMenuMemory imemory = new ItemMenuMemory();
    
    public ItemMenuController(){
        itemMenuDTO = new ItemMenuDTO();
    }
    
    public void CrearItem(String nombre, String descripcionCategoria, double precio, String desc, String tipo, boolean esVegano, double gradAlcohol, double tamanioBebida, boolean aptoVegetariano, boolean aptoCeliaco, double Calorias){
        
        
        itemMenuDTO.setNombre(nombre);
        itemMenuDTO.setDescripcionCategoria(descripcionCategoria);
        itemMenuDTO.setPrecio(precio);
        itemMenuDTO.setDesc(desc);
        itemMenuDTO.setTipo(tipo);
        itemMenuDTO.setGradAlcohol(gradAlcohol);
        itemMenuDTO.setTamanioBebida(tamanioBebida);
        itemMenuDTO.setCalorias(Calorias);
        itemMenuDTO.setEsVegano(esVegano);
        itemMenuDTO.setAptoCeliaco(aptoCeliaco);
        itemMenuDTO.setAptoVegetariano(aptoVegetariano);
        
        imemory.agregarItem(itemMenuDTO);
    }
}
