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
@Named(value = "huespedRegistroBean")
@ViewScoped
public class HuespedRegistroBean implements Serializable {
    private HuespedRegistro huespedRegistro;
    private Huesped huesped;
    private RegistroCliente registroCliente;
    
    private Integer huespedid;
    private Integer registroclienteid;

    private boolean showDialog = false;
    
    
    
    @EJB
    private HuespedRegistroFacadeLocal huespedRegistroFacade;
    @EJB
    private HuespedFacadeLocal huespedFacade;
    @EJB
    private RegistroClienteFacadeLocal registroClienteFacade;
    
    
    @PostConstruct
    public void init(){
        huespedRegistro = new HuespedRegistro();
        huesped = new Huesped();
        registroCliente = new RegistroCliente();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("huespedRegistro", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarHuespedRegistro(){
        
        huesped = huespedFacade.findHuesped(new Huesped(huespedid));
        registroCliente = registroClienteFacade.findRegistroCliente(new RegistroCliente(registroclienteid));
        
        huespedRegistro.setIdhuesped(huesped);
        huespedRegistro.setIdregistrocliente(registroCliente);
        
        huespedRegistroFacade.saveHuespedRegistro(huespedRegistro);
        showDialog = false;
        
        huespedRegistro = new HuespedRegistro();
        huesped = new Huesped();
        registroCliente = new RegistroCliente();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public HuespedRegistro getHuespedRegistro() {
        return huespedRegistro;
    }

    public void setHuespedRegistro(HuespedRegistro huespedRegistro) {
        this.huespedRegistro = huespedRegistro;
    }

    public Integer getHuespedid() {
        return huespedid;
    }

    public void setHuespedid(Integer huespedid) {
        this.huespedid = huespedid;
    }

    public Integer getRegistroclienteid() {
        return registroclienteid;
    }

    public void setRegistroclienteid(Integer registroclienteid) {
        this.registroclienteid = registroclienteid;
    }

    

    
    
}
