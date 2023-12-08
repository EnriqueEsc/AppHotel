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
@Named(value = "reporteReservacionBean")
@ViewScoped
public class ReporteReservacionBean implements Serializable {
    private ReporteReservacion reporteReservacion;
    private Reservacion reservacion;
    private Cliente cliente;
    
    private Integer reservacionid;
    private Integer clienteid;

    private boolean showDialog = false;
    
    
    
    @EJB
    private ReporteReservacionFacadeLocal reporteReservacionFacade;
    @EJB
    private ReservacionFacadeLocal reservacionFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    
    @PostConstruct
    public void init(){
        reporteReservacion = new ReporteReservacion();
        reservacion = new Reservacion();
        cliente = new Cliente();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("reporteReservacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarReporteReservacion(){
        
        reservacion = reservacionFacade.findReservacion(new Reservacion(reservacionid));
        cliente = clienteFacade.findCliente(new Cliente(clienteid));
        
        reporteReservacion.setIdreservacion(reservacion);
        reporteReservacion.setIdcliente(cliente);
        
        reporteReservacion.setNombre(cliente.getNombre());
        reporteReservacion.setApellidos(cliente.getApellidos());
        reporteReservacion.setHuella(cliente.getHuella());
        reporteReservacion.setTipohabitacion(reservacion.getTipohabitacion());
        reporteReservacion.setPrecio(reservacion.getPrecio());
        reporteReservacion.setFechaingreso(reservacion.getFechaingreso());
        reporteReservacion.setFechasalida(reservacion.getFechasalida());
        
        reporteReservacionFacade.saveReporteReservacion(reporteReservacion);
        showDialog = false;
        
        reporteReservacion = new ReporteReservacion();
        reservacion = new Reservacion();
        cliente = new Cliente();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public ReporteReservacion getReporteReservacion() {
        return reporteReservacion;
    }

    public void setReporteReservacion(ReporteReservacion reporteReservacion) {
        this.reporteReservacion = reporteReservacion;
    }

    public Integer getReservacionid() {
        return reservacionid;
    }

    public void setReservacionid(Integer reservacionid) {
        this.reservacionid = reservacionid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    
    
}
