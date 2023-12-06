/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fi.disenio.backing;

import fi.disenho.entities.*;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author jcs
 */
@Named(value = "usuariosBean")
@ViewScoped
public class UsuariosBean implements Serializable {
    private Usuario usuario;
    
    private List<Usuario> usuarioList;
    
    private TimeZone timeZone = TimeZone.getTimeZone("Americas/MexicoCity");

    private boolean showDialog = false;
    
    
    @PostConstruct
    public void init(){
    }
    
    public void registrarPersona(){
        
        showDialog = false;
    }
    
    public void setUsuarioEdit(Usuario usu){
        usuario = usu;
        
        showDialog = true;
    }
    
    public void eliminarUsuario(Usuario usr){
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
    
    
    
}
