/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Prueba;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author jcs
 */
@Local
public interface PruebaFacadeLocal {
    public void savePrueba(Prueba prueba);
}
