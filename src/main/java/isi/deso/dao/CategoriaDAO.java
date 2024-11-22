/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Categoria;
import isi.deso.model.TipoDeItem;
import jakarta.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import jakarta.persistence.NoResultException;
/**
 *
 * @author Fran Balsamo
 */
public class CategoriaDAO {
   public void crearCategoria(Categoria categoriaNew){
       Transaction transaction = null;
       
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           transaction = session.beginTransaction();
           session.persist(categoriaNew);
           transaction.commit();
       }catch(PersistenceException e ){
           if(transaction !=null){
               transaction.rollback();
           }
           e.printStackTrace();
           throw new PersistenceException("Error al agregar la categoria");
       }       
   }
   public Categoria buscarCategoria(String descripcion){
       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String jpql = "FROM Categoria c WHERE c.descripcion = :descripcion";
            Query<Categoria> query = session.createQuery(jpql, Categoria.class);
            query.setParameter("descripcion", descripcion);
            return query.uniqueResult();
        } catch (NoResultException e) {
            System.out.println("No se encontró ninguna categoria con la descripcion: " + descripcion);
            return null; // Devuelve null si no se encuentra el categoria
            }

    }
   
   public List<String> obtenerCategorias(TipoDeItem tipoItem){
       if(tipoItem.equals(TipoDeItem.PLATO)){
           return obtenerPlatos();
       }
       else 
           return obtenerBebidas();
   }
   
   private List<String> obtenerPlatos(){
       List<String> lista = new ArrayList<String>();
       
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           String hql = "SELECT descripcion FROM Categoria WHERE tipo = 'PLATO'";
           lista = session.createQuery(hql, String.class).getResultList();
       }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los Platos", e);
       }
       return lista;
   }
   
    private List<String> obtenerBebidas(){
       List<String> lista = new ArrayList<String>();
       
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           String hql = "SELECT descripcion FROM Categoria WHERE tipo = 'BEBIDA'";
           lista = session.createQuery(hql, String.class).getResultList();
       }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener las Bebidas", e);
       }
       return lista;
   }
}
