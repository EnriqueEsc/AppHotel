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
    public PosibleReservacion findPosibleReservacion(String id){
        Query query = em.createNamedQuery("PosibleReservacion.findByIdposiblereservacion");
        query.setParameter("idposiblereservacion",id);
        
        try{
             return (PosibleReservacion)query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @Override
    public List<PosibleReservacion> getPosibleReservaciones(){
        return em.createNamedQuery("ReporteReservacion.findAll").getResultList();
    }
}
