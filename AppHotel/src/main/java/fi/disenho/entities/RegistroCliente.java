/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "registro_cliente")
@NamedQueries({
    @NamedQuery(name = "RegistroCliente.findAll", query = "SELECT r FROM RegistroCliente r"),
    @NamedQuery(name = "RegistroCliente.findByIdregistrocliente", query = "SELECT r FROM RegistroCliente r WHERE r.idregistrocliente = :idregistrocliente"),
    @NamedQuery(name = "RegistroCliente.findByFechaingreso", query = "SELECT r FROM RegistroCliente r WHERE r.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "RegistroCliente.findByFechasalida", query = "SELECT r FROM RegistroCliente r WHERE r.fechasalida = :fechasalida"),
    @NamedQuery(name = "RegistroCliente.findByIdusuarioingreso", query = "SELECT r FROM RegistroCliente r WHERE r.idusuarioingreso = :idusuarioingreso"),
    @NamedQuery(name = "RegistroCliente.findByIdusuariosalida", query = "SELECT r FROM RegistroCliente r WHERE r.idusuariosalida = :idusuariosalida")})
public class RegistroCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idregistrocliente")
    private Integer idregistrocliente;
    @Basic(optional = false)
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Basic(optional = false)
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Basic(optional = false)
    @Column(name = "idusuarioingreso")
    private int idusuarioingreso;
    @Basic(optional = false)
    @Column(name = "idusuariosalida")
    private int idusuariosalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idregistrocliente")
    private Collection<HuespedRegistro> huespedRegistroCollection;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion")
    @ManyToOne(optional = false)
    private Habitacion idhabitacion;

    public RegistroCliente() {
    }

    public RegistroCliente(Integer idregistrocliente) {
        this.idregistrocliente = idregistrocliente;
    }

    public RegistroCliente(Integer idregistrocliente, Date fechaingreso, Date fechasalida, int idusuarioingreso, int idusuariosalida) {
        this.idregistrocliente = idregistrocliente;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.idusuarioingreso = idusuarioingreso;
        this.idusuariosalida = idusuariosalida;
    }

    public Integer getIdregistrocliente() {
        return idregistrocliente;
    }

    public void setIdregistrocliente(Integer idregistrocliente) {
        this.idregistrocliente = idregistrocliente;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public int getIdusuarioingreso() {
        return idusuarioingreso;
    }

    public void setIdusuarioingreso(int idusuarioingreso) {
        this.idusuarioingreso = idusuarioingreso;
    }

    public int getIdusuariosalida() {
        return idusuariosalida;
    }

    public void setIdusuariosalida(int idusuariosalida) {
        this.idusuariosalida = idusuariosalida;
    }

    public Collection<HuespedRegistro> getHuespedRegistroCollection() {
        return huespedRegistroCollection;
    }

    public void setHuespedRegistroCollection(Collection<HuespedRegistro> huespedRegistroCollection) {
        this.huespedRegistroCollection = huespedRegistroCollection;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Habitacion getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Habitacion idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistrocliente != null ? idregistrocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroCliente)) {
            return false;
        }
        RegistroCliente other = (RegistroCliente) object;
        if ((this.idregistrocliente == null && other.idregistrocliente != null) || (this.idregistrocliente != null && !this.idregistrocliente.equals(other.idregistrocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.RegistroCliente[ idregistrocliente=" + idregistrocliente + " ]";
    }
    
}
