package isi.deso.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;
import isi.deso.model.Vendedor;
import jakarta.persistence.NoResultException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ivogo
 */
public class VendedorDAO {
    public  void crearVendedor(Vendedor vendedorNew){
      Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          session.persist(vendedorNew);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al agregar el Vendedor", e);
      }
    };
    public  void eliminarVendedor(){};
    public  void actualizarVendedor(){};
    public  Vendedor buscarVendedor(String dni){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "FROM Vendedor v WHERE v.dni = :dni";
            Query<Vendedor> query = session.createQuery(jpql, Vendedor.class);
            query.setParameter("dni", dni);
            return query.uniqueResult();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún vendedor con el dni: " + dni);
            return null; // Devuelve null si no se encuentra el vendedor
            }

        }
    
    };

