/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.dto.ItemsPedidoDTO;
import isi.deso.model.Cliente;
import isi.deso.model.Estado;
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
    
    public List<Pedido> buscarPedidoPorVendedor(String dni){
        String hql = "FROM Pedido p JOIN fetch p.vendedor v WHERE v.dni = :dni";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
          List <Pedido> Pedidos = session.createQuery(hql, Pedido.class).setParameter("dni", dni).getResultList();
          return Pedidos;
          
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los pedidos", e);
        }        
    }
    
    public List<Pedido> buscarPedidoPorCliente(String cuit){
        String hql = "FROM Pedido p JOIN fetch p.cliente c WHERE c.cuit = :cuit";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
        List <Pedido> Pedidos = session.createQuery(hql, Pedido.class).setParameter("cuit", cuit).getResultList();
        return Pedidos;
          
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los pedidos", e);
        }  
    }
    
    public List<Pedido> buscarTodosPedidos(){
        String hql = "FROM Pedido";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
        List <Pedido> Pedidos = session.createQuery(hql, Pedido.class).getResultList();
        return Pedidos;
          
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los pedidos", e);
        }  
    }
    
    public void cambiarEstado(int id, String estado){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Pedido pedido = session.find(Pedido.class, id);
            pedido.setEstado(Estado.valueOf(estado));
            session.merge(pedido);
            transaction.commit();
        }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al cambiar el estado del Pedido", e);
      }
    }
}
