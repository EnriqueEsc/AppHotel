/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Reservacion;
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
public class ReservacionFacade implements ReservacionFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveReservacion(Reservacion reservacion){
        em.persist(reservacion);
        
    }
    
    @Override
    public Reservacion findReservacion(Reservacion reservacion){
        return em.find(Reservacion.class, reservacion.getIdreservacion());
    }
    
    @Override
    public List<Reservacion> getReservaciones(){
        return em.createNamedQuery("Reservacion.findAll").getResultList();
    }
    
    
    @Override
    public void removeReservacion(Reservacion reser){
        em.remove(em.merge(reser));
    }
}
