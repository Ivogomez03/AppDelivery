/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

/**
 *
 * @author Fran Balsamo
 */
public class CategoriaDTO {
    private String descripcion;
    private String tipoItem;
    
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getTipoItem(){
        return this.tipoItem;
    }
    
    public void setDescripcion(String descripcionNew){
        this.descripcion = descripcionNew;
    }
    public void setTipoItem(String tipoItemNew){
        this.tipoItem = tipoItemNew;
    }
}
