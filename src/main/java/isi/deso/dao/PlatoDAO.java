/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Plato;
import jakarta.persistence.PersistenceException;
import java.util.List;
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
    
    public List<Plato> obtenerPlatos(String dniVendedor){
        String hql = "FROM ItemMenu im JOIN Plato p ON im.id = p.id"
                + " JOIN Vendedor v ON im.vendedor.id = v.id"
                + " WHERE v.dni = :DNI ";
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Plato> listaPlatos = session.createQuery(hql, Plato.class).setParameter("DNI", dniVendedor).getResultList();
            return listaPlatos;
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los Platos", e);
       }    
    }
}
