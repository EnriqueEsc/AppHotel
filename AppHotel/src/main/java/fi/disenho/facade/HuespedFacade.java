/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Huesped;
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
public class HuespedFacade implements HuespedFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveHuesped(Huesped huesped){
        em.persist(huesped);
        
    }
    
    @Override
    public Huesped findHuesped(Huesped huesped){
        return em.find(Huesped.class, huesped.getIdhuesped());
    }
    
    @Override
    public List<Huesped> getHuespedes(){
        return em.createNamedQuery("Huesped.findAll").getResultList();
    }
}
