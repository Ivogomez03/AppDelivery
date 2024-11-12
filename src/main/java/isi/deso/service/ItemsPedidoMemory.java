/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ItemsPedidoDao;
import isi.deso.exception.ItemNoEncontradoException;
import isi.deso.model.Cliente;
import isi.deso.model.ItemMenu;
import isi.deso.model.ItemsPedido;
import isi.deso.model.Pedido;
import isi.deso.model.Vendedor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
/**
 *
 * @author ivogo
 */

public class ItemsPedidoMemory implements ItemsPedidoDao {
    private List<ItemsPedido> itemsPedidos;
    
    public void addItemsPedidos(ItemsPedido item){
        this.itemsPedidos.add(item);
    }
    
    public List<ItemsPedido> getItemsPedidos(){
        return this.itemsPedidos;
    }
    public ItemsPedidoMemory(List<ItemsPedido> i){
        this.itemsPedidos = i;
    }
    
    @Override
    public List buscarPorVendedor(Vendedor v) throws ItemNoEncontradoException{
        List menus = v.getItems();
        Stream<ItemMenu> stream = menus.stream();
        List<Integer> ids = (List<Integer>) stream.map(i->i.getId()).collect(Collectors.toList());
        List<ItemsPedido> ret = new ArrayList();
        for(int i=0; i<itemsPedidos.size(); i++){
            Integer idPedido = itemsPedidos.get(i).getIDPedido();
            if(ids.contains(idPedido)){
                ret.add(itemsPedidos.get(i));
            }
        }
        if(ret.isEmpty()) throw new ItemNoEncontradoException("No se han encontrado datos");
        
        return ret;
    }
    
    @Override
    public List buscarPorCliente(Cliente c) throws ItemNoEncontradoException{
        List<Pedido> pedido = c.getPedidos();
        List<ItemsPedido> ret = new ArrayList();
        
        for(int i=0; i<pedido.size(); i++){
            ret.addAll(pedido.get(i).getDetalle());
        }
        if(ret.isEmpty()) throw new ItemNoEncontradoException("No se han encontrado datos");
        return ret;
    }
    
    @Override
    public List<String> buscarPorRangodePrecio(int min, int max) throws ItemNoEncontradoException{
        List<String> ret = new ArrayList();
        
        for(int i=0; i<this.itemsPedidos.size();i++){
            if(this.itemsPedidos.get(i).getItemMenu().getPrecio() >= min && this.itemsPedidos.get(i).getItemMenu().getPrecio() <= max){
                ret.add(this.itemsPedidos.get(i).getItemMenu().toString());
            }
        }
        if(ret.isEmpty()) throw new ItemNoEncontradoException("No se han encontrado datos");
        return ret;
    }
    
    @Override
    public List<ItemsPedido> ordenarPorPrecio(boolean asc) {
        // Crear una copia de la lista original y ordenarla
        List<ItemsPedido> sortedList = new ArrayList<>(itemsPedidos);
        Comparator<ItemsPedido> comparator = Comparator.comparingDouble(ItemsPedido::getPrecio);

        if (!asc) {
            comparator = comparator.reversed();
        }

        sortedList.sort(comparator);
        return sortedList;
    }
    
    
}