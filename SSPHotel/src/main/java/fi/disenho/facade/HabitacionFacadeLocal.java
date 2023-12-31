/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Habitacion;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface HabitacionFacadeLocal {
    public void saveHabitacion(Habitacion habitacion);
    public Habitacion findHabitacion(Habitacion habitacion);
    public List<Habitacion> getHabitaciones();
    public void removeHabitacion(Habitacion habitacion);
    public List<Habitacion> findDisponibles();
    public List<Habitacion> findByEstado(String str);
}
