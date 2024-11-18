/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Bebida;
import isi.deso.model.ItemMenu;
import isi.deso.model.Plato;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<ItemMenu> obtenerItems(){
       List<Object> lista1 = new ArrayList<>();
       List<Object> lista2 = new ArrayList<>();
    
       
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           
           String hql = "FROM Bebida";
           String hql1 = "FROM Plato";
           
           lista1 = session.createQuery(hql, Bebida.class).getResultList();
           lista2 = session.createQuery(hql1, Plato.class).getResultList();
           lista1.addAll(lista2);
       }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los ItemsMenu", e);
       }
       return ;
   }
}
