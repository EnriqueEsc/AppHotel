/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "habitacion")
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
    @NamedQuery(name = "Habitacion.findByIdhabitacion", query = "SELECT h FROM Habitacion h WHERE h.idhabitacion = :idhabitacion"),
    @NamedQuery(name = "Habitacion.findByCodigohabitacion", query = "SELECT h FROM Habitacion h WHERE h.codigohabitacion = :codigohabitacion"),
    @NamedQuery(name = "Habitacion.findByEstado", query = "SELECT h FROM Habitacion h WHERE h.estado = :estado")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhabitacion")
    private Integer idhabitacion;
    @Basic(optional = false)
    @Column(name = "codigohabitacion")
    private String codigohabitacion;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhabitacion")
    private Collection<Reservacion> reservacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhabitacion")
    private Collection<RegistroCliente> registroClienteCollection;
    @JoinColumn(name = "idtipohabitacion", referencedColumnName = "idtipohabitacion")
    @ManyToOne(optional = false)
    private TipoHabitacion idtipohabitacion;

    public Habitacion() {
    }

    public Habitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public Habitacion(Integer idhabitacion, String codigohabitacion, String estado) {
        this.idhabitacion = idhabitacion;
        this.codigohabitacion = codigohabitacion;
        this.estado = estado;
    }

    public Integer getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getCodigohabitacion() {
        return codigohabitacion;
    }

    public void setCodigohabitacion(String codigohabitacion) {
        this.codigohabitacion = codigohabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    public Collection<RegistroCliente> getRegistroClienteCollection() {
        return registroClienteCollection;
    }

    public void setRegistroClienteCollection(Collection<RegistroCliente> registroClienteCollection) {
        this.registroClienteCollection = registroClienteCollection;
    }

    public TipoHabitacion getIdtipohabitacion() {
        return idtipohabitacion;
    }

    public void setIdtipohabitacion(TipoHabitacion idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhabitacion != null ? idhabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.idhabitacion == null && other.idhabitacion != null) || (this.idhabitacion != null && !this.idhabitacion.equals(other.idhabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.Habitacion[ idhabitacion=" + idhabitacion + " ]";
    }
    
}
