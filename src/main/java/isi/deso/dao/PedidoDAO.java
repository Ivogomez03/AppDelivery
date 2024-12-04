/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.dto.ItemsPedidoDTO;
import isi.deso.model.Cliente;
import isi.deso.model.ItemMenu;
import isi.deso.model.ItemsPedido;
import isi.deso.model.Pedido;
import isi.deso.model.Vendedor;
import jakarta.persistence.PersistenceException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class PedidoDAO {
    ClienteDAO clienteDAO = new ClienteDAO();
    VendedorDAO vendedorDAO = new VendedorDAO();
    
    public PedidoDAO(){};
    
    public void crearPedido(Pedido pedido, List<ItemsPedidoDTO> itemsPedidoDTO){
        Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        
        for(ItemsPedidoDTO dto : itemsPedidoDTO) {
            ItemMenu itemMenu = session.find(ItemMenu.class, dto.getIdItem());
            ItemsPedido itemsPedido = new ItemsPedido();
            itemsPedido.setCantidad(dto.getCantidad());
            itemsPedido.setItemMenu(itemMenu);
            itemsPedido.setPedido(pedido);
            pedido.getDetalle().add(itemsPedido);
        }
        Cliente cliente = session.find(Cliente.class, pedido.cliente.getId());
        Vendedor vendedor = session.find(Vendedor.class, pedido.vendedor.getId());
        
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        
        session.persist(pedido.getPago());
        
        session.persist(pedido);
        transaction.commit();
    }catch (PersistenceException e) {
        e.printStackTrace();
        throw new PersistenceException("Error al agregar el Pedido", e);
        }    
    };
    public void eliminarPedido(){};
    public void actualizarPedido(){};
    public void buscarPedido(){};
    
}
