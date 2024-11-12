/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

import isi.deso.model.Cliente;
import isi.deso.model.Estado;
import isi.deso.model.ItemsPedido;
import isi.deso.model.Pago;
import isi.deso.model.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author ivogo
 */
public class PedidoDTO {
    private int id;
    private ArrayList<ItemsPedido> detalle;
    private Estado estado;
    private Pago pago;

    
    public int getId(){
        return this.id;
    }
    
    public ArrayList<ItemsPedido> getDetalle(){
        return this.detalle;
    }
    
    public Estado getEstado(){
        return this.estado;
    }
    
    public Pago getPago(){
        return this.pago;
    }
}
