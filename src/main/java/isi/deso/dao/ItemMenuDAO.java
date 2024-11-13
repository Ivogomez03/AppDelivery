/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.ItemMenu;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class ItemMenuDAO {
    public void crearItemMenu(ItemMenu item){
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.persist(item);
        transaction.commit();
    }catch (PersistenceException e) {
        e.printStackTrace();
        throw new PersistenceException("Error al agregar el Item", e);
        }    
    };
    public void eliminarItemMenu(){};
    public void actualizarItemMenu(){};
    public void buscarItemMenu(){};
}
