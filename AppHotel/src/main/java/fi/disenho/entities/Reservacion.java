/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "reservacion")
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r"),
    @NamedQuery(name = "Reservacion.findByIdreservacion", query = "SELECT r FROM Reservacion r WHERE r.idreservacion = :idreservacion"),
    @NamedQuery(name = "Reservacion.findByTipohabitacion", query = "SELECT r FROM Reservacion r WHERE r.tipohabitacion = :tipohabitacion"),
    @NamedQuery(name = "Reservacion.findByDescripcion", query = "SELECT r FROM Reservacion r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reservacion.findByPrecio", query = "SELECT r FROM Reservacion r WHERE r.precio = :precio"),
    @NamedQuery(name = "Reservacion.findByFechaingreso", query = "SELECT r FROM Reservacion r WHERE r.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Reservacion.findByFechasalida", query = "SELECT r FROM Reservacion r WHERE r.fechasalida = :fechasalida"),
    @NamedQuery(name = "Reservacion.findByIdusuario", query = "SELECT r FROM Reservacion r WHERE r.idusuario = :idusuario"),
    @NamedQuery(name = "Reservacion.findByEstado", query = "SELECT r FROM Reservacion r WHERE r.estado = :estado")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idreservacion")
    private Integer idreservacion;
    @Basic(optional = false)
    @Column(name = "tipohabitacion")
    private String tipohabitacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Basic(optional = false)
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion")
    @ManyToOne(optional = false)
    private Habitacion idhabitacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreservacion")
    private Collection<ReporteReservacion> reporteReservacionCollection;

    public Reservacion() {
    }

    public Reservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Reservacion(Integer idreservacion, String tipohabitacion, String descripcion, BigDecimal precio, Date fechaingreso, Date fechasalida, int idusuario, String estado) {
        this.idreservacion = idreservacion;
        this.tipohabitacion = tipohabitacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
        this.idusuario = idusuario;
        this.estado = estado;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Collection<ReporteReservacion> getReporteReservacionCollection() {
        return reporteReservacionCollection;
    }

    public void setReporteReservacionCollection(Collection<ReporteReservacion> reporteReservacionCollection) {
        this.reporteReservacionCollection = reporteReservacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservacion != null ? idreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idreservacion == null && other.idreservacion != null) || (this.idreservacion != null && !this.idreservacion.equals(other.idreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.Reservacion[ idreservacion=" + idreservacion + " ]";
    }
    
}
