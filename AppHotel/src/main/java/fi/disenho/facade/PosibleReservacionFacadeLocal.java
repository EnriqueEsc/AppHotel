/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.PosibleReservacion;
import jakarta.ejb.Local;
import java.util.List;
/**
 *
 * @author Enrique
 */
@Local
public interface PosibleReservacionFacadeLocal {
    public void savePosibleReservacion(PosibleReservacion posibleReservacion);
    public PosibleReservacion findPosibleReservacion(String id);
    public List<PosibleReservacion> getPosibleReservaciones();
}
