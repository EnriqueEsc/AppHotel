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
@Named(value = "reservacionBean")
@ViewScoped
public class ReservacionBean implements Serializable {
    private Reservacion reservacion;
    private Habitacion habitacion;
    private Cliente cliente;
    private Usuario usuario;
    
    private Integer habitacionid;
    private Integer clienteid;
    private Integer usuarioid;

    private boolean showDialog = false;
    
    
    
    @EJB
    private ReservacionFacadeLocal reservacionFacade;
    @EJB
    private HabitacionFacadeLocal habitacionFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private UsuarioFacadeLocal usuariosFacade;
    
    
    @PostConstruct
    public void init(){
        reservacion = new Reservacion();
        habitacion = new Habitacion();
        cliente = new Cliente();
        usuario = new Usuario();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("reservacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarReservacion(){
        
        habitacion = habitacionFacade.findHabitacion(new Habitacion(habitacionid));
        cliente = clienteFacade.findCliente(new Cliente(clienteid));
        
        reservacion.setIdhabitacion(habitacion);
        reservacion.setIdcliente(cliente);
        
        reservacion.setEstado(habitacion.getEstado());
        reservacion.setTipohabitacion(habitacion.getIdtipohabitacion().getIdtipohabitacion()+"");
        reservacion.setDescripcion(habitacion.getIdtipohabitacion().getDescripcion());            
        
        
        reservacionFacade.saveReservacion(reservacion);
        showDialog = false;
        reservacion = new Reservacion();
        habitacion = new Habitacion();
        cliente = new Cliente();
        usuario = new Usuario();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getHabitacionid() {
        return habitacionid;
    }

    public void setHabitacionid(Integer habitacionid) {
        this.habitacionid = habitacionid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }
    
    

    
    
}
