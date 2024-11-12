/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Cliente;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class ClienteDAO {
    
    public void crearCliente(Cliente clienteNew){ 
        Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.persist(clienteNew);
        transaction.commit();
    }catch (ConstraintViolationException e){
        if(transaction != null){
            transaction.rollback();
        }
        throw new RuntimeException("El cliente ya existe",e);
    }catch (PersistenceException e) {
        if(transaction != null){
            transaction.rollback();
        }
        e.printStackTrace();
        throw new PersistenceException("Error al agregar el Cliente", e);
        }    
};
    public void eliminarCliente(){};
    public void actualizarCliente(){};
    public void buscarCliente(){};
}
