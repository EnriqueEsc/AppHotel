/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fi.disenho.backing;


import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import fi.disenho.entities.*;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Locale;

/**
 *
 * @author jcs
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    @Size(message = "El campo corroe no es válido", min = 1)
    private String correo;
    
    @Size(min = 1, max = 8, message = "Longitud de password no válido")
    private String passwd;
    
    private Usuario usuario;
    
    
    private Locale locale = new Locale("es", "MX");
    
    
    
    public void cambiarIdioma(String lg, String pais){
        locale = new Locale(lg, pais);
    }
    
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    
    
    
}
