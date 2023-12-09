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
@Named(value = "tipoHabitacionBean")
@ViewScoped
public class TipoHabitacionBean implements Serializable {
    private TipoHabitacion tipoHabitacion;

    private boolean showDialog = false;
    
    private List<TipoHabitacion> listTiposHabitaciones;
    
    
    
    @EJB
    private TipoHabitacionFacadeLocal tipoHabitacionFacade;
    
    
    @PostConstruct
    public void init(){
        tipoHabitacion = new TipoHabitacion();
        
        getTHs();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("tipoHabitacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarTipoHabitacion(){
        tipoHabitacionFacade.saveTipoHabitacion(tipoHabitacion);
        showDialog = false;
        tipoHabitacion = new TipoHabitacion();
        
        getTHs();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    public void getTHs(){
        listTiposHabitaciones = tipoHabitacionFacade.getTiposHabitaciones();
    }

    public List<TipoHabitacion> getListTiposHabitaciones() {
        return listTiposHabitaciones;
    }

    public void setListTiposHabitaciones(List<TipoHabitacion> listTiposHabitaciones) {
        this.listTiposHabitaciones = listTiposHabitaciones;
    }
    
    
}
