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
@Named(value = "posibleReservacionBean")
@ViewScoped
public class PosibleReservacionBean implements Serializable {
    private PosibleReservacion posibleReservacion;

    private boolean showDialog = false;
    
    private List<PosibleReservacion> listPosiblesReservaciones;
    
    
    
    @EJB
    private PosibleReservacionFacadeLocal posibleReservacionFacade;
    
    
    @PostConstruct
    public void init(){
        posibleReservacion = new PosibleReservacion();
        
        getPRs();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("posibleReservacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarPosibleReservacion(){
        posibleReservacionFacade.savePosibleReservacion(posibleReservacion);
        showDialog = false;
        posibleReservacion = new PosibleReservacion();
        
        getPRs();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public PosibleReservacion getPosibleReservacion() {
        return posibleReservacion;
    }

    public void setPosibleReservacion(PosibleReservacion posibleReservacion) {
        this.posibleReservacion = posibleReservacion;
    }
    
    public void getPRs(){
        listPosiblesReservaciones = posibleReservacionFacade.getPosibleReservaciones();
    }

    public List<PosibleReservacion> getListPosiblesReservaciones() {
        return listPosiblesReservaciones;
    }

    public void setListPosiblesReservaciones(List<PosibleReservacion> listPosiblesReservaciones) {
        this.listPosiblesReservaciones = listPosiblesReservaciones;
    }
    
    
    public void setPosibleReservacionEdit(PosibleReservacion pr){
        
       posibleReservacion = pr;
        

        if(posibleReservacionFacade.findPosibleReservacion(posibleReservacion) != null)
            posibleReservacionFacade.removePosibleReservacion(posibleReservacion);
        posibleReservacionFacade.savePosibleReservacion(posibleReservacion);
        
        
        posibleReservacion = new PosibleReservacion();
        
        getPRs();
        
        showDialog = true;
        
    }
    
    
    public void eliminarReservacion(PosibleReservacion pr){
        
        posibleReservacion  = pr;
        
        if(posibleReservacionFacade.findPosibleReservacion(posibleReservacion) != null)
            posibleReservacionFacade.removePosibleReservacion(posibleReservacion);
        
        
        posibleReservacion = new PosibleReservacion();
        
        getPRs();
        
    }
    
    
    
    
}
