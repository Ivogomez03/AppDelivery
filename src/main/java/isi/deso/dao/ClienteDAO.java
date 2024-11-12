/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Cliente;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class ClienteDAO {
    
    public void crearCliente(Cliente cliente){
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    
        session.beginTransaction();
        session.persist(cliente);
        session.getTransaction().commit();
    } catch (PersistenceException e) {
        e.printStackTrace();
        throw new PersistenceException("Error al agregar el Cliente", e);
        }
    
    };
    public void eliminarCliente(){};
    public void actualizarCliente(){};
    public void buscarCliente(){};
}
