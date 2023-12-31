/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author jcs
 */
@Stateless
public class PruebaFacade implements PruebaFacadeLocal {
    @PersistenceContext(unitName = "disenio_unit")
    private EntityManager em;
    
    @Override
    public void savePrueba(Prueba prueba){
        em.merge(prueba);
    }
    
}
