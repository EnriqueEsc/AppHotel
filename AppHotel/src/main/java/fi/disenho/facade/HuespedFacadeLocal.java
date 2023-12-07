/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Huesped;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface HuespedFacadeLocal {
    public void saveHuesped(Huesped huesped);
    public Huesped findHuesped(String id);
    public List<Huesped> getHuespedes();
}
