/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Habitacion;
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
public class HabitacionFacade implements HabitacionFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    /*
    @Override
    public void saveHabitacion(Habitacion habitacion){
        em.persist(habitacion);
        
    }
*/
    @Override
    public void saveHabitacion(Habitacion habitacion){
        em.merge(habitacion);
    }
    
    @Override
    public Habitacion findHabitacion(Habitacion habitacion){
        return em.find(Habitacion.class, habitacion.getIdhabitacion());
    }
    
    @Override
    public List<Habitacion> getHabitaciones(){
        return em.createNamedQuery("Habitacion.findAll").getResultList();
    }
    
    
    
    @Override
    public List<Habitacion> findDisponibles(){
        Query query = em.createNamedQuery("Habitacion.findByEstado");
        query.setParameter("estado", "Disponible");
        
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    
    
    @Override
    public List<Habitacion> findByEstado(String str){
        Query query = em.createNamedQuery("Habitacion.findByEstado");
        query.setParameter("estado", str);
        
        try{
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public void removeHabitacion(Habitacion habitacion){
        em.remove(em.merge(habitacion));
    }
}
