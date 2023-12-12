/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.RegistroCliente;
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
public class RegistroClienteFacade implements RegistroClienteFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveRegistroCliente(RegistroCliente registroCliente){
        em.persist(registroCliente);
        
    }
    
    @Override
    public RegistroCliente findRegistroCliente(RegistroCliente registroCliente){
        return em.find(RegistroCliente.class, registroCliente.getIdregistrocliente());
    }
    
    @Override
    public List<RegistroCliente> getRegistroClientes(){
        return em.createNamedQuery("RegistroCliente.findAll").getResultList();
    }
    
    @Override
    public void removeRegistroCliente(RegistroCliente rc){
        em.remove(em.merge(rc));
    }
}
