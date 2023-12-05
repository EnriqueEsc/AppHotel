/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.TipoHabitacion;
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
public class TipoHabitacionFacade implements TipoHabitacionFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    /*
    @Override
    public void saveTipoHabitacion(TipoHabitacion tipoHabitacion){
        em.persist(tipoHabitacion);
        
    }
*/
    
    @Override
    public TipoHabitacion findTipoHabitacion(String id){
        Query query = em.createNamedQuery("TipoHabitacion.findByIdtipohabitacion");
        query.setParameter("idtipohabitacion",id);
        
        try{
             return (TipoHabitacion)query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @Override
    public List<TipoHabitacion> getTiposHabitaciones(){
        return em.createNamedQuery("TipoHabitacion.findAll").getResultList();
    }
}
