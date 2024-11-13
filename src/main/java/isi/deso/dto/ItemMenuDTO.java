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
    
    private String nombre;
    private String descripcionCategoria;
    private double precio;
    private String desc;
    private String tipo;
    private boolean esVegano;
    private double gradAlcohol;
    private double tamanioBebida;
    private boolean aptoVegetariano;
    private boolean aptoCeliaco;
    double Calorias;
    
    public ItemMenuDTO(){};
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getCategoria(){
        return this.descripcionCategoria;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    public void setGradAlcohol(double gradAlcohol) {
        this.gradAlcohol = gradAlcohol;
    }

    public void setTamanioBebida(double tamanioBebida) {
        this.tamanioBebida = tamanioBebida;
    }

    public void setAptoVegetariano(boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }
    
    public void setCalorias(double calorias){
        this.Calorias = calorias;
    }
}
