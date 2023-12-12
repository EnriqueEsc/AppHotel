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
        Query query = em.createNamedQuery("Usuario.findByCredentials");
        query.setParameter("correo", correo);
        query.setParameter("clave", clave);
        
        try{
            return (Usuario)query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public Usuario findUsuario(Usuario usuario){
        return em.find(Usuario.class, usuario.getIdusuario());
    }
    
    @Override
    public List<Usuario> getUsuarios(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
    
    @Override
    public void removeUsuario(Usuario usr){
        em.remove(em.merge(usr));
    }
    
}
