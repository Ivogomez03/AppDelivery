package isi.deso.model;

import jakarta.persistence.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pablo
 */

@Entity
public class Plato extends ItemMenu {
    @Column(name = "cant_calorias")
    private int calorias;
    @Column(name = "aptoCeliaco")
    private boolean aptoCeliaco;
    @Column(name = "aptoVegetariano")
    private boolean aptoVegetariano;
    
    public Plato(){
        super();
    }
    
    public Plato(String nombre, String descripcion, Categoria categoria, double precio, int calorias, boolean aptoCeliaco, boolean aptoVegetariano, boolean aptoVegano,Vendedor vendedor){
        super(nombre, descripcion, categoria, precio, aptoVegano,vendedor);
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegetariano = aptoVegetariano;
    }
    
    @Override
    public double peso(double p){
       return (1.1 * p);
    }
    @Override
    public boolean esComida(){
        return true;
    }
    @Override
    public boolean esBebida(){
        return false;
    }
    
    @Override
    public boolean getAptoVegano(){
        return this.aptoVegano;
    }
    
    public boolean getAptoVegetariano(){
        return this.aptoVegetariano;
    }
    
    public int getCalorias(){
        return this.calorias;
    }    
    public boolean getAptoCeliaco(){
        return this.aptoCeliaco;
    }
    
    public void setCalorias(int cal){
        this.calorias = cal;
    }    
    public void setAptoCeliaco(boolean x){
        this.aptoCeliaco = x;
    }    
    public void setAptoVegetariano(boolean x){
        this.aptoVegetariano = x;
    }
    public boolean setAptoVegetariano(){
        return this.aptoVegetariano;
    }
}
