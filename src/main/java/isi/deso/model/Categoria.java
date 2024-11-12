/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;

import jakarta.persistence.*;

/**
 *
 * @author franc
 */

@Entity
public class Categoria {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    private TipoDeItem tipo;
    
    public Categoria(int id, String descripcion, TipoDeItem tipo){
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    public String toString(){
        return this.id + " " + this.descripcion + " " + this.tipo;
    }
}
