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
import java.lang.String;
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
    
    public List<Plato> obtenerPlatos(String dniVendedor){
        return platoDAO.obtenerPlatos(dniVendedor);
    }
    
    public List<Plato> obtenerPlatosSinTACC(String dniVendedor){
        return platoDAO.obtenerPlatosSinTACC(dniVendedor);
    }
    
    public Plato obtenerPlato(String nombre){
        return platoDAO.obtenerPlato(nombre);
    }
    
    public List<Plato> obtenerPlatoPorNombre(String nombre){
        return platoDAO.obtenerPorNombre(nombre);
    }
    
    public List<Bebida> obtenerBebidasSinAlcohol(String dniVendedor){
        return bebidaDAO.obtenerBebidasSinAlcohol(dniVendedor);
    }
    public List<Bebida> obtenerBebidasConAlcohol(String dniVendedor){
        return bebidaDAO.obtenerBebidasConAlcohol(dniVendedor);
    }
    
    public Bebida obtenerBebida(String nombre){
        return bebidaDAO.obtenerBebida(nombre);
    }
    
    public List<Bebida> obtenerBebidaPorNombre(String nombre){
        return bebidaDAO.obtenerBebidaPorNombre(nombre);
    }
    
    public List<Plato> obtenerTodosPlatos(){
        return platoDAO.obtenerTodos();
    }
    
    public List<Bebida> obtenerTodasBebidas(){
        return bebidaDAO.obtenerTodos();
    }
    
    public void habilitarItem(int id, String tipo){
    
        if(tipo.equals("Plato")){
            platoDAO.habilitarPlato(id);
        }
        else{
            bebidaDAO.habilitarBebida(id);
        }
    }
    
    public void deshabilitarItem(int id, String tipo){
        if(tipo.equals("Plato")){
            platoDAO.deshabilitarPlato(id);
        }
        else{
            bebidaDAO.deshabilitarBebida(id);
        }
    }
    
}
