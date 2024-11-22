/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.BebidaDAO;
import isi.deso.dao.ItemMenuDAO;
import isi.deso.dao.PlatoDAO;
import isi.deso.dto.ItemMenuDTO;
import isi.deso.model.Bebida;
import isi.deso.model.Categoria;
import isi.deso.model.ItemMenu;
import isi.deso.model.Plato;
import isi.deso.model.Vendedor;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ivogo
 */
public class ItemMenuMemory {
    private final ItemMenuDAO itemDAO;
    private final PlatoDAO platoDAO;
    private final BebidaDAO bebidaDAO;
    public ItemMenuMemory(){
        this.itemDAO = new ItemMenuDAO();
        this.platoDAO = new PlatoDAO();
        this.bebidaDAO = new BebidaDAO();
    }
    
    public void agregarItem(ItemMenuDTO itemDTO){
        if(itemDTO.getTipo().equals("Plato")){
            Plato plato = new Plato(itemDTO.getNombre(), itemDTO.getDesc(), itemDTO.getCategoria(), itemDTO.getPrecio(), itemDTO.getCalorias(), itemDTO.getAptoCeliaco(), itemDTO.getAptoVegetariano(), itemDTO.getEsVegano(),itemDTO.getVendedor());
            
            platoDAO.crearPlato(plato);
            //persistir
        }else{
            Bebida bebida = new Bebida(itemDTO.getNombre(), itemDTO.getDesc(), itemDTO.getCategoria(), itemDTO.getPrecio(), itemDTO.getTamanioBebida(), itemDTO.getGradAlcohol(), itemDTO.getEsVegano(),itemDTO.getVendedor());
            bebidaDAO.crearBebida(bebida);
            //persistir
        }
    }
    public List<ItemMenu> devolverListaItems(){
        List<ItemMenu> lista = itemDAO.obtenerItems();
        return lista;
    }
}
