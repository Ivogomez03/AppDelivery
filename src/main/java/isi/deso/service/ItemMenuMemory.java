/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ItemMenuDAO;
import isi.deso.dto.ItemMenuDTO;

/**
 *
 * @author ivogo
 */
public class ItemMenuMemory {
    private final ItemMenuDAO ItemDAO;
    
    public ItemMenuMemory(){
    this.ItemDAO = new ItemMenuDAO();
    }
    
    public void agregarItem(ItemMenuDTO ItemDTO){
        //Logica de si es Plato o Bebida
    }
}
