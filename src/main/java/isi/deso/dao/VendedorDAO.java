package isi.deso.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import isi.deso.model.Coordenada;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;
import isi.deso.model.Vendedor;
import jakarta.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
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
    public void eliminarVendedor(int id){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Vendedor vendedor = session.find(Vendedor.class, id);
          vendedor.setActivo(false);
          session.merge(vendedor);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al editar el Vendedor", e);
      }
    };
    public  void actualizarVendedor(Vendedor vendedor){
        Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
          transaction = session.beginTransaction();
          Vendedor vendedorMock = session.find(Vendedor.class, vendedor.getId());
          Coordenada coordenada = vendedorMock.getCoordenada();
          coordenada.setLat(vendedor.getCoordenada().getLat());
          coordenada.setLng(vendedor.getCoordenada().getLng());
          vendedor.setCoordenadaEntidad(coordenada);
          session.merge(vendedor);
          transaction.commit();
      }catch(PersistenceException e){
          if(transaction != null){
              transaction.rollback();
          }
          e.printStackTrace();
        throw new PersistenceException("Error al editar el Vendedor", e);
      }
    };
    
    public  Vendedor buscarVendedor(String dni){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "FROM Vendedor v JOIN FETCH v.coordenadas WHERE v.dni = :dni and v.activo = true";
            Query<Vendedor> query = session.createQuery(jpql, Vendedor.class);
            query.setParameter("dni", dni);
            return query.uniqueResult();
        } catch (NoResultException e) {
            System.out.println("No se encontró ningún vendedor con el dni: " + dni);
            return null; // Devuelve null si no se encuentra el vendedor
            }

        }
    
    public List<Vendedor> mostrarTodosVendedores(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Realiza la consulta HQL para obtener todos los vendedores
            String hql = "FROM Vendedor v WHERE v.activo = true";
            Query<Vendedor> query = session.createQuery(hql, Vendedor.class);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
            } // Devuelve una lista vacía en caso de error
        }
    }
    

