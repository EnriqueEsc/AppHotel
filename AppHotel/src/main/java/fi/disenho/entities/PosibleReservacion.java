/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "posible_reservacion")
@NamedQueries({
    @NamedQuery(name = "PosibleReservacion.findAll", query = "SELECT p FROM PosibleReservacion p"),
    @NamedQuery(name = "PosibleReservacion.findByIdposiblereservacion", query = "SELECT p FROM PosibleReservacion p WHERE p.idposiblereservacion = :idposiblereservacion"),
    @NamedQuery(name = "PosibleReservacion.findByFecharealizacionreserva", query = "SELECT p FROM PosibleReservacion p WHERE p.fecharealizacionreserva = :fecharealizacionreserva"),
    @NamedQuery(name = "PosibleReservacion.findByFechainicio", query = "SELECT p FROM PosibleReservacion p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "PosibleReservacion.findByFechasalida", query = "SELECT p FROM PosibleReservacion p WHERE p.fechasalida = :fechasalida"),
    @NamedQuery(name = "PosibleReservacion.findByNombre", query = "SELECT p FROM PosibleReservacion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PosibleReservacion.findByCorreo", query = "SELECT p FROM PosibleReservacion p WHERE p.correo = :correo"),
    @NamedQuery(name = "PosibleReservacion.findByTelefono1", query = "SELECT p FROM PosibleReservacion p WHERE p.telefono1 = :telefono1"),
    @NamedQuery(name = "PosibleReservacion.findByTelefono2", query = "SELECT p FROM PosibleReservacion p WHERE p.telefono2 = :telefono2"),
    @NamedQuery(name = "PosibleReservacion.findByComentario", query = "SELECT p FROM PosibleReservacion p WHERE p.comentario = :comentario")})
public class PosibleReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idposiblereservacion")
    private Integer idposiblereservacion;
    @Basic(optional = false)
    @Column(name = "fecharealizacionreserva")
    @Temporal(TemporalType.DATE)
    private Date fecharealizacionreserva;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "telefono1")
    private String telefono1;
    @Basic(optional = false)
    @Column(name = "telefono2")
    private String telefono2;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;

    public PosibleReservacion() {
    }

    public PosibleReservacion(Integer idposiblereservacion) {
        this.idposiblereservacion = idposiblereservacion;
    }

    public PosibleReservacion(Integer idposiblereservacion, Date fecharealizacionreserva, Date fechainicio, Date fechasalida, String nombre, String correo, String telefono1, String telefono2, String comentario) {
        this.idposiblereservacion = idposiblereservacion;
        this.fecharealizacionreserva = fecharealizacionreserva;
        this.fechainicio = fechainicio;
        this.fechasalida = fechasalida;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.comentario = comentario;
    }

    public Integer getIdposiblereservacion() {
        return idposiblereservacion;
    }

    public void setIdposiblereservacion(Integer idposiblereservacion) {
        this.idposiblereservacion = idposiblereservacion;
    }

    public Date getFecharealizacionreserva() {
        return fecharealizacionreserva;
    }

    public void setFecharealizacionreserva(Date fecharealizacionreserva) {
        this.fecharealizacionreserva = fecharealizacionreserva;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposiblereservacion != null ? idposiblereservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosibleReservacion)) {
            return false;
        }
        PosibleReservacion other = (PosibleReservacion) object;
        if ((this.idposiblereservacion == null && other.idposiblereservacion != null) || (this.idposiblereservacion != null && !this.idposiblereservacion.equals(other.idposiblereservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.PosibleReservacion[ idposiblereservacion=" + idposiblereservacion + " ]";
    }
    
}
