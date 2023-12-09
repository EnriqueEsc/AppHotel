/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Cliente;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface ClienteFacadeLocal {
    public void saveCliente(Cliente cliente);
    public Cliente findCliente(Cliente cliente);
    public List<Cliente> getClientes();
    
}
