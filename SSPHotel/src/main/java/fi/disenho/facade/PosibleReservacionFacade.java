/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.PosibleReservacion;
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
public class PosibleReservacionFacade implements PosibleReservacionFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void savePosibleReservacion(PosibleReservacion posibleReservacion){
        em.persist(posibleReservacion);
        
    }
    
    @Override
    public PosibleReservacion findPosibleReservacion(PosibleReservacion pr){
        return em.find(PosibleReservacion.class, pr.getIdposiblereservacion());
    }
    
    @Override
    public List<PosibleReservacion> getPosibleReservaciones(){
        return em.createNamedQuery("PosibleReservacion.findAll").getResultList();
    }
    
    @Override
    public void removePosibleReservacion(PosibleReservacion reser){
        em.remove(em.merge(reser));
    }
}
