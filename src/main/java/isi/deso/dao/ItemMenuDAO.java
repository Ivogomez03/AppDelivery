/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;

import isi.deso.model.Bebida;
import isi.deso.model.ItemMenu;
import isi.deso.model.Plato;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;

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
    public void actualizarItemMenu(String nombre, String descripcion, double precio, int id){
        Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ItemMenu item = session.find(ItemMenu.class, id);
            item.setNombre(nombre);
            item.setPrecio(precio);
            item.setDescripcion(descripcion);
            session.merge(item);
            transaction.commit();
           
        } catch (NoResultException e) {
            System.out.println("No se encontró el item a modificar");
            }
    };
    public ItemMenu buscarItemMenu(int id){
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ItemMenu item = session.find(ItemMenu.class, id);
            return item;
        } catch (NoResultException e) {
            System.out.println("No se encontró el item");
            return null; // Devuelve null si no se encuentra el vendedor
            }
    };
    
    public List<ItemMenu> obtenerItems(){
       List<ItemMenu> lista = new ArrayList<>();

    
       
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
           
           String hql = "FROM ItemMenu";
 
           
           lista = session.createQuery(hql, ItemMenu.class).getResultList();

       }catch(Exception e){
           e.printStackTrace();
           throw new RuntimeException("Se ha producido un error al obtener los ItemsMenu", e);
       }
       return lista;
   }
}
