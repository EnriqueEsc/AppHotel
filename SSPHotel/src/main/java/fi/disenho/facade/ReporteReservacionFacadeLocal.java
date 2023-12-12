/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.ReporteReservacion;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface ReporteReservacionFacadeLocal {
    public void saveReporteReservacion(ReporteReservacion reporteReservacion);
    public ReporteReservacion findReporteReservacion(ReporteReservacion rr);
    public List<ReporteReservacion> getReportesReservaciones();
    public void removeReporteReservacion(ReporteReservacion rr);
    
}