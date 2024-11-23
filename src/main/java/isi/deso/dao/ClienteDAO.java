/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Cliente;
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
    public void eliminarCliente(){}
    public void actualizarCliente(){}
    
    public Cliente buscarCliente(String cuit){
    
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String jpql = "FROM Cliente c WHERE c.cuit = :cuit";
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
            String hql = "FROM Cliente";
            Query<Cliente> query = session.createQuery(hql, Cliente.class);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
            } // Devuelve una lista vacía en caso de error
        }
}
