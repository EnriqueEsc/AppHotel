/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenho.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "huesped_registro")
@NamedQueries({
    @NamedQuery(name = "HuespedRegistro.findAll", query = "SELECT h FROM HuespedRegistro h"),
    @NamedQuery(name = "HuespedRegistro.findByIdhr", query = "SELECT h FROM HuespedRegistro h WHERE h.idhr = :idhr")})
public class HuespedRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhr")
    private Integer idhr;
    @JoinColumn(name = "idhuesped", referencedColumnName = "idhuesped")
    @ManyToOne(optional = false)
    private Huesped idhuesped;
    @JoinColumn(name = "idregistrocliente", referencedColumnName = "idregistrocliente")
    @ManyToOne(optional = false)
    private RegistroCliente idregistrocliente;

    public HuespedRegistro() {
    }

    public HuespedRegistro(Integer idhr) {
        this.idhr = idhr;
    }

    public Integer getIdhr() {
        return idhr;
    }

    public void setIdhr(Integer idhr) {
        this.idhr = idhr;
    }

    public Huesped getIdhuesped() {
        return idhuesped;
    }

    public void setIdhuesped(Huesped idhuesped) {
        this.idhuesped = idhuesped;
    }

    public RegistroCliente getIdregistrocliente() {
        return idregistrocliente;
    }

    public void setIdregistrocliente(RegistroCliente idregistrocliente) {
        this.idregistrocliente = idregistrocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhr != null ? idhr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HuespedRegistro)) {
            return false;
        }
        HuespedRegistro other = (HuespedRegistro) object;
        if ((this.idhr == null && other.idhr != null) || (this.idhr != null && !this.idhr.equals(other.idhr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.HuespedRegistro[ idhr=" + idhr + " ]";
    }
    
}
