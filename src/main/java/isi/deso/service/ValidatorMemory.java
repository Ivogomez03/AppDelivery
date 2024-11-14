package isi.deso.service;

import isi.deso.dto.VendedorDTO;
import isi.deso.dto.ClienteDTO;
import isi.deso.dto.ItemMenuDTO;
import jakarta.persistence.EntityExistsException;
import org.hibernate.Session;
import util.HibernateUtil;

public class ValidatorMemory {

    public boolean uniquenessValidationVendedor(VendedorDTO vendedorDTO) { 
        String hql = "SELECT CASE WHEN EXISTS (FROM Vendedor v WHERE v.dni = :dni) THEN true ELSE false END";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Ejecuta la consulta y busca un registro con el DNI
            Boolean exists = session.createQuery(hql, Boolean.class)
                        .setParameter("dni", vendedorDTO.getDni())
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
    public boolean uniquenessValidationCliente(ClienteDTO clienteDTO) { 
        String hql = "SELECT CASE WHEN EXISTS (FROM Cliente c WHERE c.cuit = :cuit) THEN true ELSE false END";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Ejecuta la consulta y busca un registro con el DNI
            Boolean exists = session.createQuery(hql, Boolean.class)
                        .setParameter("cuit", clienteDTO.getCuit())
                        .uniqueResult();

            // Retorna true si no se encontró el vendedor (es decir, si `result` es null)
            return exists == false;
        }catch (EntityExistsException e) {
            e.printStackTrace();
            throw new RuntimeException("El cliente ya existe", e);
        }catch (Exception e){
            throw new RuntimeException("Se a producido algun error en la validacion",e);
        }
        
    }
    public boolean uniquenessValidationItemMenu(ItemMenuDTO itemMenuDTO) { 
        String hql = "SELECT CASE WHEN EXISTS (FROM ItemMenu i WHERE i.nombre = :nombre) THEN true ELSE false END";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Ejecuta la consulta y busca un registro con el DNI
            Boolean exists = session.createQuery(hql, Boolean.class)
                        .setParameter("nombre", itemMenuDTO.getNombre())
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
}
