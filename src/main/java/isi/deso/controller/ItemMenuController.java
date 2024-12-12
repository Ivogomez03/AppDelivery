/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.ItemMenuDTO;
import isi.deso.model.Bebida;
import isi.deso.model.Categoria;
import isi.deso.model.ItemMenu;
import isi.deso.model.Plato;
import isi.deso.service.CategoriaMemory;
import isi.deso.service.ItemMenuMemory;
import isi.deso.service.VendedorMemory;
import java.util.List;


/**
 *
 * @author ivogo
 */
public class ItemMenuController {
    private ItemMenuDTO itemMenuDTO;
    private ItemMenuMemory imemory = new ItemMenuMemory();
    private VendedorMemory vmemory = new VendedorMemory();
    private CategoriaMemory cmemory = new CategoriaMemory();
    public ItemMenuController(){
        itemMenuDTO = new ItemMenuDTO();
    }
    
    public void CrearItem(String nombre, String descripcionCategoria, double precio, String desc, String tipo, boolean esVegano, double gradAlcohol, int tamanioBebida, boolean aptoVegetariano, boolean aptoCeliaco, int Calorias, String dniVendedor){
        Categoria categoria = cmemory.buscarCategoria(descripcionCategoria);
        
        itemMenuDTO.setNombre(nombre);
        itemMenuDTO.setCategoria(categoria);
        itemMenuDTO.setPrecio(precio);
        itemMenuDTO.setDesc(desc);
        itemMenuDTO.setTipo(tipo);
        itemMenuDTO.setGradAlcohol(gradAlcohol);
        itemMenuDTO.setTamanioBebida(tamanioBebida);
        itemMenuDTO.setCalorias(Calorias);
        itemMenuDTO.setEsVegano(esVegano);
        itemMenuDTO.setAptoCeliaco(aptoCeliaco);
        itemMenuDTO.setAptoVegetariano(aptoVegetariano);
        itemMenuDTO.setVendedor(vmemory.buscarVendedor(dniVendedor));
        
        imemory.agregarItem(itemMenuDTO);
    }
    
    public List<ItemMenu> obtenerItemsMenu(){
        List<ItemMenu> lista = imemory.devolverListaItems();
        return lista;
        
    }
    
    public List<Plato> obtenerPlatoPorNombre(String nombre){
        return imemory.obtenerPlatoPorNombre(nombre);
    }
    
    public List<Bebida> obtenerBebidaPorNombre(String nombre){
        return imemory.obtenerBebidaPorNombre(nombre);
    }
    
    public List<Plato> obtenerTodosPlatos(){
        return imemory.obtenerTodosPlatos();
    }
    
    public List<Bebida> obtenerTodasBebidas(){
        return imemory.obtenerTodasBebidas();
    }
    
    public void habilitarItem(int id, String tipo){
        imemory.habilitarItem(id, tipo);
    }
    
    public void deshabilitarItem(int id, String tipo){
        imemory.deshabilitarItem(id, tipo);
    }
}
