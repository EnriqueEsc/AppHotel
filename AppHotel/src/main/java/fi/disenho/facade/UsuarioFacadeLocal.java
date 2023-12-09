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
 * @author jcs
 */
@Local
public interface UsuarioFacadeLocal {
    public void saveUsuario(Usuario usuario);
    public Usuario findUsuario(String correo, String clave);
    public Usuario findUsuario(Usuario usuario);
    public List<Usuario> getUsuarios();
    public void removeUsurio(Usuario usu);
}
