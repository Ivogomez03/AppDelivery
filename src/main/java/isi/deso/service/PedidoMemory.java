/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.service;

import isi.deso.dao.ClienteDAO;
import isi.deso.dao.PedidoDAO;
import isi.deso.dao.VendedorDAO;
import isi.deso.dto.ItemsPedidoDTO;
import isi.deso.dto.PedidoDTO;
import isi.deso.model.Cliente;
import isi.deso.model.ItemsPedido;
import isi.deso.model.Pago;
import isi.deso.model.Pedido;
import isi.deso.model.TipoPago;
import isi.deso.model.Vendedor;
import java.util.List;

/**
 *
 * @author ivogo
 */
public class PedidoMemory {
    PedidoDAO pedidoDAO = new PedidoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    VendedorDAO vendedorDAO = new VendedorDAO();
    Pedido pedido = new Pedido();
    
    public void crearPedido(PedidoDTO pedidoDTO){
        Cliente cliente = new Cliente();
        Vendedor vendedor = new Vendedor();
        TipoPago tipoDePago = TipoPago.valueOf(pedidoDTO.getPago());
        Pago pago = new Pago(pedidoDTO.getMontoPago(), tipoDePago, pedidoDTO.getCredenciales());
        cliente = clienteDAO.buscarCliente(pedidoDTO.getCuitCliente());
        vendedor = vendedorDAO.buscarVendedor(pedidoDTO.getDNIVendedor());
        
        pedido.setPago(pago);
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        
        pedidoDAO.crearPedido(pedido, pedidoDTO.getDetalle());    
    }
    
    public List<Pedido> buscarPedidoPorVendedor(String dni){
        return pedidoDAO.buscarPedidoPorVendedor(dni);
    }
    
    public List<Pedido> buscarPedidoPorCliente(String cuit){
        return pedidoDAO.buscarPedidoPorCliente(cuit);
    }
    
    public List<Pedido> buscarTodosPedidos(){
        return pedidoDAO.buscarTodosPedidos();
    }
    
    public void cambiarEstado(int id, String estado){
        pedidoDAO.cambiarEstado(id, estado);
    }
}
