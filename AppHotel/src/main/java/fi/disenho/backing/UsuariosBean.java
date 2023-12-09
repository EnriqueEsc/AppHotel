/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fi.disenho.backing;

import fi.disenho.entities.*;
import fi.disenho.facade.*;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
    
    private List<Usuario> listUsuarios;
    
    private TimeZone timeZone = TimeZone.getTimeZone("Americas/MexicoCity");

    private boolean showDialog = false;
    
    
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        
        listUsuarios = getUsuarios();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("registro", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void registrarPersona(){
        usuarioFacade.saveUsuario(usuario);
        listUsuarios = getUsuarios();
        showDialog = false;
    }
    public void guardarUsuario(){
        usuarioFacade.saveUsuario(usuario);
        showDialog = false;
        usuario = new Usuario();
        
        listUsuarios = getUsuarios();
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

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
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
    
    public List<Usuario> getUsuarios(){
        return usuarioFacade.getUsuarios();
    }
    
    
}
