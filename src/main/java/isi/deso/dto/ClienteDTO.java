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
   
    public ClienteDTO(){};
    
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
    public String setEmail(String email){
        return this.email = email;
    }
    public String setCUIT(String CUIT){
        return this.cuit = CUIT;
    }
    public String setDireccion(String direccion){
        return this.direccion = direccion;
    }
    public double setLatitud(double latitud){
        return this.latitud = latitud;
    }
    public double setLongitud(double longitud){
        return this.longitud = longitud;
    }
    
    
}
