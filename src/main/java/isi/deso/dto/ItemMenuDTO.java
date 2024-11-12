/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

import isi.deso.model.Categoria;
import isi.deso.model.TipoDeItem;

/**
 *
 * @author ivogo
 */
public class ItemMenuDTO {
    private int id;
    private String nombre;
    private Categoria categoria;
    private double precio;
    private String desc;
    private TipoDeItem tipo;
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Categoria getCategoria(){
        return this.categoria;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public TipoDeItem getTipo(){
        return this.tipo;
    }
}
