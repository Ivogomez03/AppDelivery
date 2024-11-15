package isi.deso.model;


import jakarta.persistence.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Francisco
 */

@Entity
public class Cliente {
    @Id
    @Column(name = "id_cliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "CUIT", nullable = false)
    private String cuit;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coordenadas", referencedColumnName = "id_coordenadas")
    private Coordenada coordenadas;
    
    @Transient //Temporal
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Pedido> pedidos;
    
    public Cliente(){};
    
    public Cliente(String email, String cuit, String direccion, double lat, double lng){
        this.email=email;
        this.cuit=cuit;
        this.direccion=direccion;
        this.coordenadas = new Coordenada(lat,lng);
    } 
    
    public int getId(){
        return this.id;
    }    
    public String getEmail(){
        return this.email;
    }    
    public String getCuit(){
        return this.cuit;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public Coordenada getCoordenada(){
        return this.coordenadas;
    }
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    
    public void setid(int id){
        this.id=id;
    }   
    public void setEmail(String email){
        this.email=email;
    }    
    public void setCuit(String cuit){
        this.cuit = cuit;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    } 
    public void setCoordenada(Coordenada coordenada){
       this.coordenadas = coordenada;
    }
    public void setPedidos(ArrayList<Pedido> items){
        this.pedidos = items;
    }
    
    public void addPedido(Pedido ped){
        this.pedidos.add(ped);
    }
    public void println(){
        System.out.println(this.getEmail() + " " + this.getDireccion() + " " + this.getCuit() + " {" + this.coordenadas.getLat() + "," + this.coordenadas.getLng()+ "}" );
    }
    public void notificarPedido(Estado e){
        System.out.println("(Notificacion para cliente con id " + this.id + ") Su pedido esta en estado de " + e);
    }
    
}
