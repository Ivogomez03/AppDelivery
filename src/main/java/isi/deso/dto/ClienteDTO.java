/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

import isi.deso.model.Coordenada;

/**
 *
 * @author ivogo
 */
public class ClienteDTO {
    
    private String email;
    private String cuit;
    private String direccion;
    private double longitud;
    private double latitud;
    
    public String getEmail(){
        return this.email;
    }
    public String getCuit(){
        return this.cuit;
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
