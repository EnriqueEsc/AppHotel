/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package fi.disenho.facade;

import fi.disenho.entities.Usuario;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Enrique
 */
@Local
public interface UsuarioFacadeLocal {
    public void saveUsuario(Usuario usuario);
    public Usuario findUsuario(String mail);
    public List<Usuario> getUsuarios();
    
}
