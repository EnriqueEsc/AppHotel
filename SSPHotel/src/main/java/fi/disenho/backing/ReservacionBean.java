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
    
    private List<Reservacion> listReservaciones;
    
    
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
        
        getReservaciones();
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
        
        getReservaciones();
        
        
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
    
    public void getReservaciones(){
        listReservaciones = reservacionFacade.getReservaciones();
    }

    public List<Reservacion> getListReservaciones() {
        return listReservaciones;
    }

    public void setListReservaciones(List<Reservacion> listReservaciones) {
        this.listReservaciones = listReservaciones;
    }
    
    
    
    public void setReservacionEdit(Reservacion reser){
        
        habitacion = habitacionFacade.findHabitacion(new Habitacion(reser.getIdhabitacion().getIdhabitacion()));
        cliente = clienteFacade.findCliente(new Cliente(reser.getIdcliente().getIdcliente()));
        
        reser.setIdhabitacion(habitacion);
        reser.setIdcliente(cliente);
               
        reser.setEstado(habitacion.getEstado());
        reser.setTipohabitacion(habitacion.getIdtipohabitacion().getIdtipohabitacion()+"");
        reser.setDescripcion(habitacion.getIdtipohabitacion().getDescripcion());            
              
        
        
        reservacion = reser;
        habitacion = reser.getIdhabitacion();
        cliente = reser.getIdcliente();
        

        if(reservacionFacade.findReservacion(reservacion) != null)
            reservacionFacade.removeReservacion(reservacion);
        reservacionFacade.saveReservacion(reservacion);
        
        
        reservacion = new Reservacion();
        habitacion = new Habitacion();
        cliente = new Cliente();
        usuario = new Usuario();
        
        getReservaciones();
        
        showDialog = true;
        
        FacesContext.getCurrentInstance()
                .addMessage("reservacion", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,reser.getPrecio()+"",""));
    }
    
    
    public void eliminarReservacion(Reservacion reser){
        reservacion = reser;
        if(reservacionFacade.findReservacion(reservacion) != null)
            reservacionFacade.removeReservacion(reservacion);
        
        
        reservacion = new Reservacion();
        habitacion = new Habitacion();
        cliente = new Cliente();
        usuario = new Usuario();
        
        getReservaciones();
        
    }
    

    
    
}
