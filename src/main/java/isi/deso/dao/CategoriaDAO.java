/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Categoria;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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
}
