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
import java.util.ArrayList;
import java.util.List;


public class VendedorDTO {
    private int id;
    private String nombre;
    private String direccion;   
    private double longitud;
    private double latitud;
    
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public double getLatitud(){
        return this.latitud;
    }
    public double getLongitud(){
        return this.longitud;
    }
}
