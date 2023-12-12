/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Cliente;
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
public class ClienteFacade implements ClienteFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveCliente(Cliente cliente){
        em.persist(cliente);
        
    }
    
    @Override
    public Cliente findCliente(Cliente cliente){
        return em.find(Cliente.class, cliente.getIdcliente());
    }
    
    @Override
    public List<Cliente> getClientes(){
        return em.createNamedQuery("Cliente.findAll").getResultList();
    }
    
    @Override
    public void removeCliente(Cliente cliente){
        em.remove(em.merge(cliente));
    }
}
