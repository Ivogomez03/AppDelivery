package isi.deso.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;
import isi.deso.model.Vendedor;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

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
      }catch(ConstraintViolationException e){
          if(transaction != null){
              transaction.rollback(); //Esto remueve la transaction hecha si se produce un error.
          }
          throw new RuntimeException("El Vendedor ya existe",e);
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
    public  void buscarVendedor(){};
}
