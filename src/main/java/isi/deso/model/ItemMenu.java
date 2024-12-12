package isi.deso.model;

import jakarta.persistence.*;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pablo
 */

@Entity
@Table(name = "item_menu")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemMenu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_menu")
    protected int id;
    
    @Column(name = "nombre")
    protected String nombre;
    
    @Column(name = "descripcion")
    protected String descripcion;
    
    @Column(name = "precio")
    protected double precio;
    
    @Column(name = "aptoVegano")
    protected boolean aptoVegano;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    protected Categoria categoria;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    protected Vendedor vendedor;
    
    @OneToMany(mappedBy = "itemMenu", fetch = FetchType.LAZY)
    private List<ItemsPedido> itemsPedidos;
    
    private boolean disponible;
    
    public abstract double peso(double p);
    public abstract boolean esComida();
    public abstract boolean esBebida();
   
    public ItemMenu(){
        disponible = true;
    }
    
    public ItemMenu(String nombre, String descripcion, Categoria categoria, double precio, boolean aptoVegano,Vendedor vendedor){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.aptoVegano = aptoVegano;
        this.vendedor = vendedor;
        this.disponible = true;
    }

    @Override
    public String toString(){
        String s = (this.getId() + " " + this.getNombre() + " " + this.getDescripcion() + " " + this.categoria.toString() + " " + this.getPrecio());
        return s;
    }
    public void printLn(){
        System.out.println(this.toString());
    }
    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public double getPrecio(){
        return this.precio;
    }
    public Categoria getCategoria(){
        return this.categoria;
    }
    public boolean getAptoVegano(){
        return this.aptoVegano;
    }
    public Vendedor getVendedor(){
        return this.vendedor;
    }
    public boolean getDisponible(){
        return this.disponible;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    public void setDescripcion(String n){
        this.descripcion = n;
    }
    
    public void setPrecio(double p){
        this.precio = p;
    }
    
    public void setAptoVegano(boolean apto){
        this.aptoVegano = apto;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }
}
