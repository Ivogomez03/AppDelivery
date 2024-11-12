package isi.deso.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco
 */

@Entity
public class Vendedor implements Observer{
    @Id
    @Column(name = "id_vendedor", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @OneToOne
    @JoinColumn(name = "id_coordenadas", referencedColumnName = "id_coordenadas")
    private Coordenada coordenadas;
    
    @ManyToMany
    @JoinTable(name = "vendedor_item", joinColumns = @JoinColumn(name = "id_vendedor"), inverseJoinColumns = @JoinColumn(name = "id_item_menu"))
    private List<ItemMenu> items; // todos los items que vende
    
    @OneToMany(mappedBy = "vendedor")
    private List<Pedido> pedidosRecibidos; //lista de los pedidos que se le realizaron al vendedor
    
    public Vendedor(){}
    
    public Vendedor(int id, String nombre, String direccion, double lat, double lng,List items){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = new Coordenada(lat,lng);
        this.items = items;
        this.pedidosRecibidos = new ArrayList<Pedido>();
    } 

    @Override
    public void actualizarEstado(pedidoObservable obs){
       
        Pedido p = (Pedido)obs;
        for(int i=0; i<this.pedidosRecibidos.size();i++){
            
            Pedido pedidoEstado = (Pedido)this.pedidosRecibidos.get(i);
            if(p.equals(pedidoEstado)){
                pedidoEstado.siguienteEstado();
            }
            else{
                System.out.println("Pedido no encontrado");
            }
        }
    }
    public void println(){
        System.out.println(this.getId() + " " + this.getNombre() + " " + this.getDireccion() + " {" + this.coordenadas.getLat() + "," + this.coordenadas.getLng()+ "}" );
    }
    public void distance(Cliente c){
        final int radioTierra = 6371; //radio en km
       
        
        //Latitudes y Longitudes en radianes
        double latV = Math.toRadians(this.coordenadas.getLat());
        double lngV = Math.toRadians(this.coordenadas.getLng());
        double latC = Math.toRadians(c.getCoordenada().getLat());
        double lngC = Math.toRadians(c.getCoordenada().getLng());
       
        double difLat = latC - latV;
        double difLng = lngC - lngV;
        
        double a = Math.sin(difLat / 2) * Math.sin(difLat / 2)
                 + Math.cos(latV) * Math.cos(latC)
                 + Math.sin(difLng / 2) * Math.sin(difLng / 2);
        double e = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        double distance = radioTierra * e;
        
        System.out.println("Distancia entre vendedor y cliente: "+ distance); 
    }
    
    public void mostrarMenu(){
        for(int i=0;i<this.items.size();i++){
            ItemMenu c = (ItemMenu)this.items.get(i);
            System.out.println("Plato " + (i+1) + ": " + c.getNombre() + " $" + c.getPrecio());
            System.out.println("Descripcion: " + c.getDescripcion());
        }
    }
    
    /*
    public void nuevoPlato(ItemMenu nuevoItem){
        if (this.items == null){
            items = new ArrayList();
            //agregar el nuevo item
        }
        else {
            //agregar el nuevo item
        }
    }
    */
    public ArrayList<Pedido> buscarPorEstado(Estado e){
        ArrayList<Pedido> pedidosPorEstado = new ArrayList();
        for(int i=0; i<this.pedidosRecibidos.size();i++){
            
            Pedido pedidoEstado = (Pedido)this.pedidosRecibidos.get(i);
            
            if(pedidoEstado.getEstado() == e){
                pedidosPorEstado.add(pedidoEstado);
            }
        }
        return pedidosPorEstado;
        
    }
    public void addPedido(Pedido p){
        
        this.pedidosRecibidos.add(p);
        
    }
    public List getBebidas(){
        List bebidas = new ArrayList();
        for(int i=0; i<this.items.size();i++){
            Bebida bebida = (Bebida)this.items.get(i);
            if(bebida.esBebida()){
                bebidas.add(bebida);
            }
        }
        return bebidas;
    }    
    public List getBebidasSinAlcohol(){
        List bebidas = new ArrayList();
        for(int i=0; i<this.items.size();i++){
            Bebida aux = (Bebida)this.items.get(i);
            if(aux.esBebida() & aux.esBebidaAlcoholica()){
                bebidas.add(aux);
            }
        }
        return bebidas;
    }        
    public List getComidas(){
        List comidas = new ArrayList();
        
        for(int i=0; i<this.items.size();i++){
            Plato aux = (Plato)this.items.get(i);
            if(aux.esComida()){
                comidas.add(aux);
            }
        }
        return comidas;
    }
    public List getComidasVeganas(){
        List comidas = new ArrayList();
        
        for(int i=0; i<this.items.size();i++){
            Plato aux = (Plato)this.items.get(i);
            if(aux.esComida() & aux.aptoVegano()){
                comidas.add(aux);
            }
        }
        return comidas;
    }
    public  int getId(){
        return this.id;
    }    
    public  String getNombre(){
        return this.nombre;
    }    
    public  String getDireccion(){
        return this.direccion;
    }
    public  Coordenada getCoordenada(){
        return this.coordenadas;
    }
    public List getItems(){
        return this.items;
    }
    
    public void setid(int id){
        this.id=id;
    }
    public  void setNombre(String nombre){
        this.nombre = nombre;
    }    
    public  void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public  void setCoordenada(double lat, double lng){
       this.coordenadas.setLat(lat);
       this.coordenadas.setLng(lng);
    }
    public void setListaArticulos(List articulos){
        this.items = articulos;
    }

    public void addItem(ItemMenu item){
        this.items.add(item);
    }

    public void addArticulos(List<ItemMenu> articulos){ 
        for(int i=0 ; i<articulos.size() ; i++){
           this.items.add(articulos.get(i));
        }
    }
    
}
