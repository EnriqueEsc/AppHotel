/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.HuespedRegistro;
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
public class HuespedRegistroFacade implements HuespedRegistroFacadeLocal {
    
    @PersistenceContext(name = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void saveHuespedRegistro(HuespedRegistro huespedRegistro){
        em.persist(huespedRegistro);
        
    }
    
    @Override
    public HuespedRegistro findHuespedRegistro(HuespedRegistro hr){
        return em.find(HuespedRegistro.class, hr.getIdhr());
    }
    
    @Override
    public List<HuespedRegistro> getHuespedesRegistros(){
        return em.createNamedQuery("HuespedRegistro.findAll").getResultList();
    }
    
    @Override
    public void removeHuespedRegistro(HuespedRegistro hr){
        em.remove(em.merge(hr));
    }
}
