/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "reporte_reservacion")
@NamedQueries({
    @NamedQuery(name = "ReporteReservacion.findAll", query = "SELECT r FROM ReporteReservacion r"),
    @NamedQuery(name = "ReporteReservacion.findByIdreportereservacion", query = "SELECT r FROM ReporteReservacion r WHERE r.idreportereservacion = :idreportereservacion"),
    @NamedQuery(name = "ReporteReservacion.findByNombre", query = "SELECT r FROM ReporteReservacion r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "ReporteReservacion.findByApellidos", query = "SELECT r FROM ReporteReservacion r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "ReporteReservacion.findByHuella", query = "SELECT r FROM ReporteReservacion r WHERE r.huella = :huella"),
    @NamedQuery(name = "ReporteReservacion.findByTipohabitacion", query = "SELECT r FROM ReporteReservacion r WHERE r.tipohabitacion = :tipohabitacion"),
    @NamedQuery(name = "ReporteReservacion.findByPrecio", query = "SELECT r FROM ReporteReservacion r WHERE r.precio = :precio"),
    @NamedQuery(name = "ReporteReservacion.findByFechaingreso", query = "SELECT r FROM ReporteReservacion r WHERE r.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "ReporteReservacion.findByFechasalida", query = "SELECT r FROM ReporteReservacion r WHERE r.fechasalida = :fechasalida")})
public class ReporteReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idreportereservacion")
    private Integer idreportereservacion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "huella")
    private String huella;
    @Basic(optional = false)
    @Column(name = "tipohabitacion")
    private String tipohabitacion;
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
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idreservacion", referencedColumnName = "idreservacion")
    @ManyToOne(optional = false)
    private Reservacion idreservacion;

    public ReporteReservacion() {
    }

    public ReporteReservacion(Integer idreportereservacion) {
        this.idreportereservacion = idreportereservacion;
    }

    public ReporteReservacion(Integer idreportereservacion, String nombre, String apellidos, String huella, String tipohabitacion, BigDecimal precio, Date fechaingreso, Date fechasalida) {
        this.idreportereservacion = idreportereservacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.huella = huella;
        this.tipohabitacion = tipohabitacion;
        this.precio = precio;
        this.fechaingreso = fechaingreso;
        this.fechasalida = fechasalida;
    }

    public Integer getIdreportereservacion() {
        return idreportereservacion;
    }

    public void setIdreportereservacion(Integer idreportereservacion) {
        this.idreportereservacion = idreportereservacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
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

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Reservacion getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Reservacion idreservacion) {
        this.idreservacion = idreservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreportereservacion != null ? idreportereservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteReservacion)) {
            return false;
        }
        ReporteReservacion other = (ReporteReservacion) object;
        if ((this.idreportereservacion == null && other.idreportereservacion != null) || (this.idreportereservacion != null && !this.idreportereservacion.equals(other.idreportereservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.ReporteReservacion[ idreportereservacion=" + idreportereservacion + " ]";
    }
    
}
