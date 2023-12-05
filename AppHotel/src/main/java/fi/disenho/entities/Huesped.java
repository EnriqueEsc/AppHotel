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
@Table(name = "huesped")
@NamedQueries({
    @NamedQuery(name = "Huesped.findAll", query = "SELECT h FROM Huesped h"),
    @NamedQuery(name = "Huesped.findByIdhuesped", query = "SELECT h FROM Huesped h WHERE h.idhuesped = :idhuesped"),
    @NamedQuery(name = "Huesped.findByDocumentoh", query = "SELECT h FROM Huesped h WHERE h.documentoh = :documentoh"),
    @NamedQuery(name = "Huesped.findByNombreh", query = "SELECT h FROM Huesped h WHERE h.nombreh = :nombreh"),
    @NamedQuery(name = "Huesped.findByFnacimiento", query = "SELECT h FROM Huesped h WHERE h.fnacimiento = :fnacimiento"),
    @NamedQuery(name = "Huesped.findByNacionalidadh", query = "SELECT h FROM Huesped h WHERE h.nacionalidadh = :nacionalidadh"),
    @NamedQuery(name = "Huesped.findByGeneroh", query = "SELECT h FROM Huesped h WHERE h.generoh = :generoh")})
public class Huesped implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhuesped")
    private Integer idhuesped;
    @Basic(optional = false)
    @Column(name = "documentoh")
    private String documentoh;
    @Basic(optional = false)
    @Column(name = "nombreh")
    private String nombreh;
    @Basic(optional = false)
    @Column(name = "fnacimiento")
    @Temporal(TemporalType.DATE)
    private Date fnacimiento;
    @Basic(optional = false)
    @Column(name = "nacionalidadh")
    private String nacionalidadh;
    @Basic(optional = false)
    @Column(name = "generoh")
    private String generoh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhuesped")
    private Collection<HuespedRegistro> huespedRegistroCollection;

    public Huesped() {
    }

    public Huesped(Integer idhuesped) {
        this.idhuesped = idhuesped;
    }

    public Huesped(Integer idhuesped, String documentoh, String nombreh, Date fnacimiento, String nacionalidadh, String generoh) {
        this.idhuesped = idhuesped;
        this.documentoh = documentoh;
        this.nombreh = nombreh;
        this.fnacimiento = fnacimiento;
        this.nacionalidadh = nacionalidadh;
        this.generoh = generoh;
    }

    public Integer getIdhuesped() {
        return idhuesped;
    }

    public void setIdhuesped(Integer idhuesped) {
        this.idhuesped = idhuesped;
    }

    public String getDocumentoh() {
        return documentoh;
    }

    public void setDocumentoh(String documentoh) {
        this.documentoh = documentoh;
    }

    public String getNombreh() {
        return nombreh;
    }

    public void setNombreh(String nombreh) {
        this.nombreh = nombreh;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getNacionalidadh() {
        return nacionalidadh;
    }

    public void setNacionalidadh(String nacionalidadh) {
        this.nacionalidadh = nacionalidadh;
    }

    public String getGeneroh() {
        return generoh;
    }

    public void setGeneroh(String generoh) {
        this.generoh = generoh;
    }

    public Collection<HuespedRegistro> getHuespedRegistroCollection() {
        return huespedRegistroCollection;
    }

    public void setHuespedRegistroCollection(Collection<HuespedRegistro> huespedRegistroCollection) {
        this.huespedRegistroCollection = huespedRegistroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhuesped != null ? idhuesped.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Huesped)) {
            return false;
        }
        Huesped other = (Huesped) object;
        if ((this.idhuesped == null && other.idhuesped != null) || (this.idhuesped != null && !this.idhuesped.equals(other.idhuesped))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fi.disenho.entities.Huesped[ idhuesped=" + idhuesped + " ]";
    }
    
}
