/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dto;

import isi.deso.model.Cliente;
import isi.deso.model.Estado;
import isi.deso.model.Pago;
import isi.deso.model.Vendedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivogo
 */
public class PedidoDTO {
    private int id;
    private List<ItemsPedidoDTO> detalle;
    private Estado estado;
    private String pago;
    private String CuitCliente;
    private String DNIVendedor;
    private double montoPago;
    private String credenciales;
    
    public PedidoDTO(){};
    
    public int getId(){
        return this.id;
    }
    
    public List<ItemsPedidoDTO> getDetalle(){
        return this.detalle;
    }
    
    public Estado getEstado(){
        return this.estado;
    }
    
    public String getPago(){
        return this.pago;
    }
    
    public String getCuitCliente(){
        return this.CuitCliente;
    }
    
    public String getDNIVendedor(){
        return this.DNIVendedor;
    }
    
    public double getMontoPago(){
        return this.montoPago;
    }
    
    public String getCredenciales(){
        return this.credenciales;
    }
    
    public void setDetalle(List<ItemsPedidoDTO> detalle){
        this.detalle = detalle;
    }
    
    public void setPago(String pago){
        this.pago = pago;
    }
    
    public void setCuitCliente(String cuitCliente){
        this.CuitCliente = cuitCliente;
    }
    
    public void setDniVendedor(String dniVendedor){
        this.DNIVendedor = dniVendedor;
    }
    
    public void setMontoPago(double monto){
        this.montoPago = monto;
    }
    
    public void setCredenciales(String credencial){
        this.credenciales = credencial;
    }
}
