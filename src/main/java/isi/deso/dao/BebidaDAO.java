/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Bebida;
import jakarta.persistence.PersistenceException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ivogo
 */
public class BebidaDAO {
    public  void crearBebida(Bebida bebida){
      Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          session.persist(bebida);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al agregar la Bebida", e);
      }
    };
    public List<Bebida> obtenerBebidasSinAlcohol(String dniVendedor){
        String hql = "FROM ItemMenu im JOIN Bebida b ON im.id = b.id"
                + " JOIN Vendedor v ON im.vendedor.id = v.id"
                + " WHERE v.dni = :DNI AND b.graduacionAlcohol = 0 and im.disponible = true"; 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Bebida> listaBebidas = session.createQuery(hql, Bebida.class).setParameter("DNI", dniVendedor).getResultList();
            return listaBebidas;
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener las Bebidas", e);
       }    
    }
    
    public Bebida obtenerBebida(String nombre){
        String hql = "FROM ItemMenu im JOIN Bebida b ON im.id = b.id"
                + " WHERE im.nombre = :nombre and im.disponible = true";
         try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Bebida Bebida = (Bebida) session.createQuery(hql, Bebida.class).setParameter("nombre",nombre).uniqueResult();
            return Bebida;
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener la Bebida", e);
       }       
    }
    
    public List<Bebida> obtenerBebidaPorNombre(String nombre){
        String hql = "FROM ItemMenu im JOIN Bebida b ON im.id = b.id"
                + " WHERE im.nombre LIKE :nombre";
         try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Bebida> Bebidas = session.createQuery(hql, Bebida.class).setParameter("nombre",nombre+"%").getResultList();
            return Bebidas;
        }catch(Exception e){
           e.printStackTrace();
           return null;
        }
    }
    
    public List<Bebida> obtenerBebidasConAlcohol(String dniVendedor){
        String hql = "FROM ItemMenu im JOIN Bebida b ON im.id = b.id"
                + " JOIN Vendedor v ON im.vendedor.id = v.id"
                + " WHERE v.dni = :DNI AND b.graduacionAlcohol > 0 AND im.disponible = true"; 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Bebida> listaBebidas = session.createQuery(hql, Bebida.class).setParameter("DNI", dniVendedor).getResultList();
            return listaBebidas;
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener las Bebidas", e);
       }    
    }
    
    public List<Bebida> obtenerTodos(){
        String hql = "FROM ItemMenu im JOIN Bebida b ON im.id = b.id";
                
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Bebida> listaBebidas = session.createQuery(hql, Bebida.class).getResultList();
            return listaBebidas;
        }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener las Bebidas", e);
       }    
    }
    
    public void habilitarBebida(int id){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Bebida bebida = (Bebida) session.find(Bebida.class, id);
          bebida.setDisponible(true);
          session.merge(bebida);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al agregar el Plato", e);
      }
    }
    
    public void deshabilitarBebida(int id){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Bebida bebida = (Bebida) session.find(Bebida.class, id);
          bebida.setDisponible(false);
          session.merge(bebida);
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
