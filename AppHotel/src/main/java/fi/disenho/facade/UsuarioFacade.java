/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author jcs
 */
@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveUsuario(Usuario usuario){
        em.merge(usuario);
    }
    
    @Override
    public Usuario findUsuario(String correo, String clave){
        Query query = em.createNamedQuery("Usuario.findByCorreo");
        query.setParameter("correo", correo);
        
        try{
            return (Usuario)query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public List<Usuario> getUsuarios(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
    
    @Override
    public void removeUsurio(Usuario usu){
        em.remove(usu);
    }
    
}
