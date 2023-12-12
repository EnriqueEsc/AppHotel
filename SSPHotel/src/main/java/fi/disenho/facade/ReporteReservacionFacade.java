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
    public ReporteReservacion findReporteReservacion(ReporteReservacion rr){
        return em.find(ReporteReservacion.class, rr.getIdreportereservacion());
    }
    
    @Override
    public List<ReporteReservacion> getReportesReservaciones(){
        return em.createNamedQuery("ReporteReservacion.findAll").getResultList();
    }
    
    @Override
    public void removeReporteReservacion(ReporteReservacion rr){
        em.remove(em.merge(rr));
    }
}