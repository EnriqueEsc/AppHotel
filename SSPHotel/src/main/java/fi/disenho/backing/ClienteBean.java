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
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {
    private Cliente cliente;
    
    private List<Cliente> listClientes;

    private boolean showDialog = false;
    
    
    
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        listClientes = getClientes();
    }
    
    
    public void noHaceNada(){
        FacesContext.getCurrentInstance()
                .addMessage("cliente", 
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no válido",""));
    }
    
    public void guardarCliente(){
        clienteFacade.saveCliente(cliente);
        showDialog = false;
        cliente = new Cliente();
        listClientes = getClientes();
    }
    
    
    public void cancelar(){
        showDialog = false;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }
    
    
    public List<Cliente> getClientes(){
        return clienteFacade.getClientes();
    }
    
    public void setClienteEdit(Cliente clnt){
        
       cliente = clnt;
        

        if(clienteFacade.findCliente(cliente) != null)
            clienteFacade.removeCliente(cliente);
        clienteFacade.saveCliente(cliente);
        
        
        cliente = new Cliente();
        listClientes = getClientes();
        
        showDialog = true;
        
    }
    
    
    public void eliminarReservacion(Cliente clnt){
        
        cliente  = clnt;
        
        if(clienteFacade.findCliente(cliente) != null)
            clienteFacade.removeCliente(cliente);
        
        
        cliente = new Cliente();
        listClientes = getClientes();
        
    }
    
    
}
