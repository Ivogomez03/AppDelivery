/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

/**
 *
 * @author ivogo
 */

import isi.deso.model.Coordenada;
import isi.deso.model.ItemMenu;
import java.util.ArrayList;
import java.util.List;


public class VendedorDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;  
    private String dni;
    private double longitud;
    private double latitud;
    private List<ItemMenu> items;
    
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public String getDni(){
        return this.dni;
    }
    public double getLatitud(){
        return this.latitud;
    }
    public double getLongitud(){
        return this.longitud;
    }
    
    public List<ItemMenu> getItems(){
        return this.items;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public void setLatitud(double latitud){
        this.latitud = latitud;
    }
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }
}
