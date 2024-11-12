/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;

import jakarta.persistence.*;

/**
 *
 * @author ivogo
 */

@Entity
@Table(name = "Items_Pedido")
public class ItemsPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items_pedido", nullable = false)
    private int id_items_pedido;
    
    @Column
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;
    
    @OneToOne
    @JoinColumn(name = "id_item_menu", referencedColumnName = "id_item_menu")
    private ItemMenu itemMenu;
    
   
    
    public ItemsPedido(int cant,ItemMenu item, int pedido){
        this.itemMenu = item;
        this.cantidad = cant;
        this.id_items_pedido = pedido;
    }
    
    public ItemMenu getItemMenu(){
        return this.itemMenu;
    }
    
    public String toString(){
        return this.id_items_pedido + " " + this.itemMenu.toString() + " " + this.cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    public int getIDPedido(){
        return this.id_items_pedido;
    }
    public void setItemMenu(ItemMenu item){
        this.itemMenu = item;
    }
    public void setCantidad(int cant){
        this.cantidad = cant;
    }
    public void setIDPedido(int pedido){
        this.id_items_pedido = pedido;
    }
    public double getPrecio(){
        return this.itemMenu.getPrecio()*this.cantidad;
    }
    
}
