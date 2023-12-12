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
@Named(value = "habitacionBean")
@ViewScoped
public class HabitacionBean implements Serializable {
    private TipoHabitacion tipoHabitacion;
    private Habitacion habitacion;

    private boolean showDialog = false;
    
    private Integer tipohabitacionid;
    
    private List<Habitacion> listHabitaciones;
    private List<Habitacion> listDisponibles;
    private List<Habitacion> listByEstado;
    
    private String bsqSt;
    
    
    
    @EJB
    private TipoHabitacionFacadeLocal tipoHabitacionFacade;
    @EJB
    private HabitacionFacadeLocal habitacionFacade;
    
    
    @PostConstruct
    public void init(){
        tipoHabitacion = new TipoHabitacion();
        habitacion = new Habitacion();
        
        getHabitaciones();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("tipoHabitacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarHabitacion(){
        tipoHabitacion = tipoHabitacionFacade.findTipoHabitacion(new TipoHabitacion(tipohabitacionid));
        
        habitacion.setIdtipohabitacion(tipoHabitacion);
        
        
        
        habitacionFacade.saveHabitacion(habitacion);
        showDialog = false;
        
        tipoHabitacion = new TipoHabitacion();
        habitacion = new Habitacion();
        
        getHabitaciones();
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

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getTipohabitacionid() {
        return tipohabitacionid;
    }

    public void setTipohabitacionid(Integer tipohabitacionid) {
        this.tipohabitacionid = tipohabitacionid;
    }
    
    public void getHabitaciones(){
        listHabitaciones = habitacionFacade.getHabitaciones();
        
        listDisponibles = habitacionFacade.findDisponibles();
    }

    public List<Habitacion> getListHabitaciones() {
        return listHabitaciones;
    }

    public void setListHabitaciones(List<Habitacion> listHabitaciones) {
        this.listHabitaciones = listHabitaciones;
    }

    public List<Habitacion> getListDisponibles() {
        return listDisponibles;
    }

    public void setListDisponibles(List<Habitacion> listDisponibles) {
        this.listDisponibles = listDisponibles;
    }

    public List<Habitacion> getListByEstado() {
        return listByEstado;
    }

    public void setListByEstado(List<Habitacion> listByEstado) {
        this.listByEstado = listByEstado;
    }

    public String getBsqSt() {
        return bsqSt;
    }

    public void setBsqSt(String bsqSt) {
        this.bsqSt = bsqSt;
    }
    
    
    
    public void findByEstado() {
        listByEstado = habitacionFacade.findByEstado(bsqSt);
        habitacion = new Habitacion();
    }
    
    
    public void setHabitacionEdit(Habitacion hbt){
        
        tipoHabitacion = tipoHabitacionFacade.findTipoHabitacion(new TipoHabitacion(hbt.getIdtipohabitacion().getIdtipohabitacion()));
        
        habitacion.setIdtipohabitacion(tipoHabitacion);
        
        habitacion = hbt;
        tipoHabitacion = hbt.getIdtipohabitacion();
        

        if(habitacionFacade.findHabitacion(habitacion) != null)
            habitacionFacade.removeHabitacion(habitacion);
        habitacionFacade.saveHabitacion(habitacion);
        
        
        
        tipoHabitacion = new TipoHabitacion();
        habitacion = new Habitacion();
        
        getHabitaciones();
        
        showDialog = true;
        
    }
    
    
    public void eliminarHabitacion(Habitacion hbt){
        habitacion = hbt;
        

        if(habitacionFacade.findHabitacion(habitacion) != null)
            habitacionFacade.removeHabitacion(habitacion);
        
        
        
        tipoHabitacion = new TipoHabitacion();
        habitacion = new Habitacion();
        
        getHabitaciones();
        
        showDialog = true;
        
    }
    
}
