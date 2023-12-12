/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.HuespedRegistro;
import jakarta.ejb.Local;
import java.util.List;
/**
 *
 * @author Enrique
 */
@Local
public interface HuespedRegistroFacadeLocal {
    public void saveHuespedRegistro(HuespedRegistro huespedRegistro);
    public HuespedRegistro findHuespedRegistro(HuespedRegistro hr);
    public List<HuespedRegistro> getHuespedesRegistros();
    public void removeHuespedRegistro(HuespedRegistro hr);
    
}
