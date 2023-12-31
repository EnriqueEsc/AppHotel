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
@Named(value = "registroClienteBean")
@ViewScoped
public class RegistroClienteBean implements Serializable {
    private RegistroCliente registroCliente;
    private Cliente cliente;
    private Habitacion habitacion;
    private Usuario usuario;
    
    
    private Integer clienteid;
    private Integer habitacionid;
    private Integer usuarioid;

    private boolean showDialog = false;
    
    private List<RegistroCliente> listRegistrosClientes;
    
    
    
    @EJB
    private RegistroClienteFacadeLocal registroClienteFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private HabitacionFacadeLocal habitacionFacade;
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    
    @PostConstruct
    public void init(){
        registroCliente = new RegistroCliente();
        cliente = new Cliente();
        habitacion = new Habitacion();
        usuario = new Usuario();
        
        getRCs();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("registroCliente", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarRegistroCliente(){
        
        cliente = clienteFacade.findCliente(new Cliente(clienteid));
        habitacion = habitacionFacade.findHabitacion(new Habitacion(habitacionid));
        usuario = usuarioFacade.findUsuario(new Usuario(usuarioid));
        
        registroCliente.setIdcliente(cliente);
        registroCliente.setIdhabitacion(habitacion);
        registroCliente.setIdusuarioingreso((usuario).getIdusuario());
        registroCliente.setIdusuariosalida((usuario).getIdusuario());
        
        registroClienteFacade.saveRegistroCliente(registroCliente);
        showDialog = false;
        
        registroCliente = new RegistroCliente();
        cliente = new Cliente();
        habitacion = new Habitacion();
        usuario = new Usuario();
        
        getRCs();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public RegistroCliente getRegistroCliente() {
        return registroCliente;
    }

    public void setRegistroCliente(RegistroCliente registroCliente) {
        this.registroCliente = registroCliente;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getHabitacionid() {
        return habitacionid;
    }

    public void setHabitacionid(Integer habitacionid) {
        this.habitacionid = habitacionid;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }
    
    public void getRCs(){
        listRegistrosClientes = registroClienteFacade.getRegistroClientes();
    }

    public List<RegistroCliente> getListRegistrosClientes() {
        return listRegistrosClientes;
    }

    public void setListRegistrosClientes(List<RegistroCliente> listRegistrosClientes) {
        this.listRegistrosClientes = listRegistrosClientes;
    }

    
    public void setRegistroClienteEdit(RegistroCliente rc){
 
        
        cliente = clienteFacade.findCliente(new Cliente(rc.getIdcliente().getIdcliente()));
        habitacion = habitacionFacade.findHabitacion(new Habitacion(rc.getIdhabitacion().getIdhabitacion()));
        
        rc.setIdcliente(cliente);
        rc.setIdhabitacion(habitacion);
        
        registroCliente = rc;
        cliente = rc.getIdcliente();
        habitacion = rc.getIdhabitacion();
        

        if(registroClienteFacade.findRegistroCliente(registroCliente) != null)
            registroClienteFacade.removeRegistroCliente(registroCliente);
        registroClienteFacade.saveRegistroCliente(registroCliente);
        
        
        registroCliente = new RegistroCliente();
        cliente = new Cliente();
        habitacion = new Habitacion();
        usuario = new Usuario();
        
        getRCs();
        
        showDialog = true;
    }
    
    
    public void eliminarRegistroCliente(RegistroCliente rc){
        
        registroCliente = rc;
        

        if(registroClienteFacade.findRegistroCliente(registroCliente) != null)
            registroClienteFacade.removeRegistroCliente(registroCliente);
        
        
        registroCliente = new RegistroCliente();
        cliente = new Cliente();
        habitacion = new Habitacion();
        usuario = new Usuario();
        
        getRCs();
        
    }
    
}
