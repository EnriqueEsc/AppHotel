/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveUsuario(Usuario usuario){
        em.persist(usuario);
        
    }
    
    @Override
    public Usuario findUsuario(String mail){
        Query query = em.createNamedQuery("Usuario.findByCredentials");
        query.setParameter("mail",mail);
        
        try{
             return (Usuario)query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @Override
    public List<Usuario> getUsuarios(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
}
