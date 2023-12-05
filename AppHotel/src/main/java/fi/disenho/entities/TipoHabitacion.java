/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "tipo_habitacion")
@NamedQueries({
    @NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t"),
    @NamedQuery(name = "TipoHabitacion.findByIdtipohabitacion", query = "SELECT t FROM TipoHabitacion t WHERE t.idtipohabitacion = :idtipohabitacion"),
    @NamedQuery(name = "TipoHabitacion.findByDescripcion", query = "SELECT t FROM TipoHabitacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoHabitacion.findByCantidadmatrimonial", query = "SELECT t FROM TipoHabitacion t WHERE t.cantidadmatrimonial = :cantidadmatrimonial"),
    @NamedQuery(name = "TipoHabitacion.findByCantidadindividual", query = "SELECT t FROM TipoHabitacion t WHERE t.cantidadindividual = :cantidadindividual"),
    @NamedQuery(name = "TipoHabitacion.findByCantidadba\u00f1o", query = "SELECT t FROM TipoHabitacion t WHERE t.cantidadba\u00f1o = :cantidadba\u00f1o"),
    @NamedQuery(name = "TipoHabitacion.findByExtras", query = "SELECT t FROM TipoHabitacion t WHERE t.extras = :extras")})
public class TipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipohabitacion")
    private Integer idtipohabitacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidadmatrimonial")
    private short cantidadmatrimonial;
    @Basic(optional = false)
    @Column(name = "cantidadindividual")
    private short cantidadindividual;
    @Basic(optional = false)
    @Column(name = "cantidadba\u00f1o")
    private short cantidadbaño;
    @Basic(optional = false)
    @Column(name = "extras")
    private String extras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipohabitacion")
    private Collection<Habitacion> habitacionCollection;

    public TipoHabitacion() {
    }

    public TipoHabitacion(Integer idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    public TipoHabitacion(Integer idtipohabitacion, String descripcion, short cantidadmatrimonial, short cantidadindividual, short cantidadbaño, String extras) {
        this.idtipohabitacion = idtipohabitacion;
        this.descripcion = descripcion;
        this.cantidadmatrimonial = cantidadmatrimonial;
        this.cantidadindividual = cantidadindividual;
        this.cantidadbaño = cantidadbaño;
        this.extras = extras;
    }

    public Integer getIdtipohabitacion() {
        return idtipohabitacion;
    }

    public void setIdtipohabitacion(Integer idtipohabitacion) {
        this.idtipohabitacion = idtipohabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCantidadmatrimonial() {
        return cantidadmatrimonial;
    }

    public void setCantidadmatrimonial(short cantidadmatrimonial) {
        this.cantidadmatrimonial = cantidadmatrimonial;
    }

    public short getCantidadindividual() {
        return cantidadindividual;
    }

    public void setCantidadindividual(short cantidadindividual) {
        this.cantidadindividual = cantidadindividual;
    }

    public short getCantidadbaño() {
        return cantidadbaño;
    }

    public void setCantidadbaño(short cantidadbaño) {
        this.cantidadbaño = cantidadbaño;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Collection<Habitacion> getHabitacionCollection() {
        return habitacionCollection;
    }

    public void setHabitacionCollection(Collection<Habitacion> habitacionCollection) {
        this.habitacionCollection = habitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipohabitacion != null ? idtipohabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHabitacion)) {
            return false;
        }
        TipoHabitacion other = (TipoHabitacion) object;
        if ((this.idtipohabitacion == null && other.idtipohabitacion != null) || (this.idtipohabitacion != null && !this.idtipohabitacion.equals(other.idtipohabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.TipoHabitacion[ idtipohabitacion=" + idtipohabitacion + " ]";
    }
    
}
