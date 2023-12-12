/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.RegistroCliente;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface RegistroClienteFacadeLocal {
    public void saveRegistroCliente(RegistroCliente registroCliente);
    public RegistroCliente findRegistroCliente(RegistroCliente registroCliente);
    public List<RegistroCliente> getRegistroClientes();
    public void removeRegistroCliente(RegistroCliente rc);
    
}
