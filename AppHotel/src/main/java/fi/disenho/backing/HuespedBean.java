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
@Named(value = "huespedBean")
@ViewScoped
public class HuespedBean implements Serializable {
    private Huesped huesped;

    private boolean showDialog = false;
    
    private List<Huesped> listHuespedes;
    
    
    
    @EJB
    private HuespedFacadeLocal huespedFacade;
    
    
    @PostConstruct
    public void init(){
        huesped = new Huesped();
        getHuespedes();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("huesped", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarHuesped(){
        huespedFacade.saveHuesped(huesped);
        showDialog = false;
        huesped = new Huesped();
        
        
        getHuespedes();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    public void getHuespedes(){
        listHuespedes = huespedFacade.getHuespedes();
    }

    public List<Huesped> getListHuespedes() {
        return listHuespedes;
    }

    public void setListHuespedes(List<Huesped> listHuespedes) {
        this.listHuespedes = listHuespedes;
    }
    
    
}
