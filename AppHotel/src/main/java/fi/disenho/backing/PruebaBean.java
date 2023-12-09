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
 */
@Named(value = "pruebaBean")
@ViewScoped
public class PruebaBean implements Serializable {
    private Prueba prueba;

    private boolean showDialog = false;
    
    
    
    @EJB
    private PruebaFacadeLocal pruebaFacade;
    
    
    @PostConstruct
    public void init(){
        prueba = new Prueba();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("prueba", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarPrueba(){
        pruebaFacade.savePrueba(prueba);
        showDialog = false;
        prueba = new Prueba();
    }
    
    public void eliminarUsuario(Usuario usr){
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prpueba) {
        this.prueba = prueba;
    }
    
    
}
