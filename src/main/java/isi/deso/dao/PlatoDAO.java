/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Plato;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class PlatoDAO {
    public  void crearPlato(Plato plato){
      Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          session.persist(plato);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al agregar el Plato", e);
      }
    }
}
