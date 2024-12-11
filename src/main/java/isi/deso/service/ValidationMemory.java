package isi.deso.service;

import isi.deso.dto.VendedorDTO;
import isi.deso.dto.ClienteDTO;
import isi.deso.dto.ItemMenuDTO;
import jakarta.persistence.EntityExistsException;
import java.util.logging.Logger;
import org.hibernate.Session;
import util.HibernateUtil;

public class ValidationMemory {

    private static final Logger logger = Logger.getLogger(ValidationMemory.class.getName());
    
    public boolean vendedorExists(String dni){
        String hql = "SELECT CASE WHEN EXISTS (FROM Vendedor v WHERE v.dni = :dni) THEN true ELSE false END";
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Boolean exists = session.createQuery(hql, Boolean.class)
                    .setParameter("dni",dni)
                    .uniqueResult();
            return exists;
        }catch (Exception e){
            throw new RuntimeException("Se a producido algun error en la verificacion de existencia");
        }
    }
    
    public boolean uniquenessValidationVendedor(String dni) { 
        String hql = "SELECT CASE WHEN EXISTS (FROM Vendedor v WHERE v.dni = :dni and v.activo = true) THEN true ELSE false END";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Ejecuta la consulta y busca un registro con el DNI
            Boolean exists = session.createQuery(hql, Boolean.class)
                        .setParameter("dni", dni)
                        .uniqueResult();

            // Retorna true si no se encontró el vendedor (es decir, si `result` es null)
            return exists == false;
        }catch (EntityExistsException e) {
            e.printStackTrace();
            throw new RuntimeException("El vendedor ya existe", e);
        }catch (Exception e){
            throw new RuntimeException("Se a producido algun error en la validacion",e);
        }
        
    }
    public boolean ValidarCliente(String CUIT) { 
        
        String hql = "SELECT COUNT(c) FROM Cliente c WHERE c.cuit = :cuit and c.valido = true";

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery(hql, Long.class)
                            .setParameter("cuit", CUIT)
                            .uniqueResult();

            return count > 0; // Retorna true si el cliente existe
        }catch (EntityExistsException e) {
            e.printStackTrace();
            throw new RuntimeException("El cliente ya existe", e);
        }catch (Exception e){
            throw new RuntimeException("Se a producido algun error en la validacion",e);
        }
        
    }
    
    public boolean uniquenessValidationItemMenu(String nombre) { 
        String hql = "SELECT CASE WHEN EXISTS (FROM ItemMenu i WHERE i.nombre = :nombre) THEN true ELSE false END";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Ejecuta la consulta y busca un registro con el DNI
            Boolean exists = session.createQuery(hql, Boolean.class)
                        .setParameter("nombre", nombre)
                        .uniqueResult();

            // Retorna true si no se encontró el vendedor (es decir, si `result` es null)
            return exists == false;
        }catch (EntityExistsException e) {
            e.printStackTrace();
            throw new RuntimeException("El Item Menu ya existe", e);
        }catch (Exception e){
            throw new RuntimeException("Se a producido algun error en la validacion",e);
        }
        
    }
    
    public boolean ValidarSoloNumeros(String string){
        int i = 0;
        while(string.length() >i){
            if(!Character.isDigit(string.charAt(i))){
                return false; 
            }
            i++;
        }
        return true;
    }

}