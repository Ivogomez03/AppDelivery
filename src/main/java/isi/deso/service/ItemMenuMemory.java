/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ItemMenuDAO;
import isi.deso.dto.ItemMenuDTO;
import isi.deso.model.Bebida;
import isi.deso.model.ItemMenu;
import isi.deso.model.Plato;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ivogo
 */
public class ItemMenuMemory {
    private final ItemMenuDAO itemDAO;
    
    public ItemMenuMemory(){
    this.itemDAO = new ItemMenuDAO();
    }
    
    public void agregarItem(ItemMenuDTO itemDTO){
        if(itemDTO.getTipo() == "Plato"){
            Plato plato;
            //persistir
        }else{
            Bebida bebida;
            //persistir
        }
    }
    public List<ItemMenu> devolverListaItems(){
        List<ItemMenu> lista = itemDAO.obtenerItems();
        return lista;
    }
}
