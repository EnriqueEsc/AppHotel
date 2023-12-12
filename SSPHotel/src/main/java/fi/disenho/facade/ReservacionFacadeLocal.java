/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Reservacion;
import jakarta.ejb.Local;
import java.util.List;
/**
 *
 * @author Enrique
 */
@Local
public interface ReservacionFacadeLocal {
    public void saveReservacion(Reservacion reservacion);
    public Reservacion findReservacion(Reservacion reservacion);
    public List<Reservacion> getReservaciones();
    public void removeReservacion(Reservacion reser);
}
