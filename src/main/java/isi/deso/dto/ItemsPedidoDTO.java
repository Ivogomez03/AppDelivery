/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

/**
 *
 * @author franc
 */
public class ItemsPedidoDTO {
    int cantidad;
    int id_item;
    
    public ItemsPedidoDTO(){}
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setIdItem(int id_item){
        this.id_item = id_item;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public int getIdItem(){
        return this.id_item;
    }
    
}
