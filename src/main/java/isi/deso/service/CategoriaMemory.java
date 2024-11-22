/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.CategoriaDAO;
import isi.deso.dto.CategoriaDTO;
import isi.deso.model.Categoria;
import isi.deso.model.TipoDeItem;
import java.util.List;

/**
 *
 * @author Fran Balsamo
 */
public class CategoriaMemory {
    private final CategoriaDAO categoriaDAO;
    
    public CategoriaMemory(){
        this.categoriaDAO = new CategoriaDAO();
    }
    
    public void agregarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria;
        if(categoriaDTO.getTipoItem().equals("Plato")){
            categoria = new Categoria(categoriaDTO.getDescripcion(),TipoDeItem.PLATO);
        }else{
            categoria = new Categoria(categoriaDTO.getDescripcion(),TipoDeItem.BEBIDA);
        }
        try{
            categoriaDAO.crearCategoria(categoria);
            System.out.println("Se agrego de forma exitosa");
        }catch(RuntimeException e){
            if(e.getMessage().contains("La categoria ya existe")){
                System.out.println("No se pudo agregar: La categoria ya existe");
            }else{
                System.out.println("Ocurrio un error al intentar agregar la categoria");
            }
            e.printStackTrace();
        }
    }

    public List<String> obtenerListaCategoria(String tipoItem) {
        List<String> lista;
        try{
            if(tipoItem.equals("Plato")){
                lista = categoriaDAO.obtenerCategorias(TipoDeItem.PLATO);
            }else{
                lista = categoriaDAO.obtenerCategorias(TipoDeItem.BEBIDA);
            }
            System.out.println("Se a actualizado la lista de categorias con exito");
            return lista; 
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Se a producido algun error al actuaizar la lista");
        }
        return null;
    }
    
    public Categoria buscarCategoria(String desc){
        Categoria categoria = categoriaDAO.buscarCategoria(desc);
            
            if(categoria != null){
                System.out.println("Categoria con " + categoria.getDesc() + " encontrado");
                return categoria;
            } else {
                System.out.println("No se encontró la categoria.");
                return null;
            }
    
    };
}
