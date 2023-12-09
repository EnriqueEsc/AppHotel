/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.ReporteReservacion;
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
public class ReporteReservacionFacade implements ReporteReservacionFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveReporteReservacion(ReporteReservacion reporteReservacion){
        em.persist(reporteReservacion);
        
    }
    
    @Override
    public ReporteReservacion findReporteReservacion(String id){
        Query query = em.createNamedQuery("ReporteReservacion.findByIdreportereservacion");
        query.setParameter("idreportereservacion",id);
        
        try{
             return (ReporteReservacion)query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @Override
    public List<ReporteReservacion> getReportesReservaciones(){
        return em.createNamedQuery("ReporteReservacion.findAll").getResultList();
    }
}