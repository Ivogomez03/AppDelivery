/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

import isi.deso.model.Categoria;
import isi.deso.model.TipoDeItem;
import isi.deso.model.Vendedor;

/**
 *
 * @author ivogo
 */
public class ItemMenuDTO {
    
    private String nombre;
    private Categoria categoria;
    private double precio;
    private String desc;
    private String tipo;
    private boolean esVegano;
    private double gradAlcohol;
    private int tamanioBebida;
    private boolean aptoVegetariano;
    private boolean aptoCeliaco;
    private int Calorias;
    private Vendedor vendedor;
    
    public ItemMenuDTO(){};
    
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
    
    public String getTipo(){
        return this.tipo;
    }
    public Vendedor getVendedor(){
        return this.vendedor;
    }
    
    public boolean getEsVegano() {
        return this.esVegano;
    }

    public double getGradAlcohol() {
        return this.gradAlcohol;
    }

    public int getTamanioBebida() {
        return this.tamanioBebida;
    }

    public boolean getAptoVegetariano() {
        return this.aptoVegetariano;
    }

    public boolean getAptoCeliaco() {
        return this.aptoCeliaco;
    }
    
    public int getCalorias(){
       return this.Calorias;
    }
    
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public void setTamanioBebida(int tamanioBebida) {
        this.tamanioBebida = tamanioBebida;
    }

    public void setAptoVegetariano(boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }
    
    public void setCalorias(int calorias){
        this.Calorias = calorias;
    }
    public void setVendedor(Vendedor v){
        this.vendedor = v;
    }
}
