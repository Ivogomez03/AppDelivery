/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Cliente;
import isi.deso.model.Coordenada;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class ClienteDAO {
    
    public void crearCliente(Cliente cliente){ 
        Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.persist(cliente);
        transaction.commit();
    }catch (PersistenceException e) {
        e.printStackTrace();
        throw new PersistenceException("Error al agregar el Cliente", e);
        }    
}
    public void eliminarCliente(int id){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Cliente cliente = session.find(Cliente.class, id);
          cliente.setActivo(false);
          session.merge(cliente);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al editar el Vendedor", e);
      }
    }
    public void modificarCliente(Cliente cliente){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Cliente clienteMock = session.find(Cliente.class, cliente.getId());
          Coordenada coordenada = clienteMock.getCoordenada();
          coordenada.setLat(cliente.getCoordenada().getLat());
          coordenada.setLng(cliente.getCoordenada().getLng());
          cliente.setCoordenadaEntidad(coordenada);
          session.merge(cliente);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al editar el Vendedor", e);
      }
    }
    
    public Cliente buscarCliente(String cuit){
    
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String jpql = "FROM Cliente c WHERE c.cuit = :cuit and c.activo = true";
        Query<Cliente> query = session.createQuery(jpql, Cliente.class);
        query.setParameter("cuit", cuit);
        return query.uniqueResult();
    } catch (NoResultException e) {
        System.out.println("No se encontró ningún cliente con el CUIT: " + cuit);
        return null; // Devuelve null si no se encuentra el cliente
        }
        
    }
    
    public List<Cliente> mostrarTodosClientes(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Realiza la consulta HQL para obtener todos los vendedores
            String hql = "FROM Cliente c WHERE c.activo = true";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
            } // Devuelve una lista vacía en caso de error
        }
}
