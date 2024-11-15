/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.controller;

import isi.deso.dto.CategoriaDTO;
import isi.deso.service.CategoriaMemory;

/**
 *
 * @author Fran Balsamo
 */
public class CategoriaController {
    private final CategoriaDTO categoriaDTO;
    public CategoriaController(){
        this.categoriaDTO = new CategoriaDTO();
    }
    
    public void crearCategoria(String descripcionNueva, String TipoItem){
        CategoriaMemory cmemory = new CategoriaMemory();
        
        categoriaDTO.setDescripcion(descripcionNueva);
        categoriaDTO.setTipoItem(TipoItem);
        
        cmemory.agregarCategoria(categoriaDTO);
    }
}
