/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.TipoHabitacion;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface TipoHabitacionFacadeLocal {
    public void saveTipoHabitacion(TipoHabitacion tipoHabitacion);
    public TipoHabitacion findTipoHabitacion(TipoHabitacion tipoHabitacion);
    public List<TipoHabitacion> getTiposHabitaciones();
    public void removeTipoHabitacion(TipoHabitacion th);
}
