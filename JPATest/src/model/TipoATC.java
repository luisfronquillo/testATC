/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis.f.ronquillo
 */
@Entity
@Table(name = "TipoATC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoATC.findAll", query = "SELECT t FROM TipoATC t"),
    @NamedQuery(name = "TipoATC.findByIdTipoATC", query = "SELECT t FROM TipoATC t WHERE t.idTipoATC = :idTipoATC"),
    @NamedQuery(name = "TipoATC.findByTipoATC", query = "SELECT t FROM TipoATC t WHERE t.tipoATC = :tipoATC"),
    @NamedQuery(name = "TipoATC.findByDescripcionATC", query = "SELECT t FROM TipoATC t WHERE t.descripcionATC = :descripcionATC")})
public class TipoATC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTipoATC")
    private Long idTipoATC;
    @Size(max = 30)
    @Column(name = "TipoATC")
    private String tipoATC;
    @Size(max = 100)
    @Column(name = "DescripcionATC")
    private String descripcionATC;
    @OneToMany(mappedBy = "fKIdTipoATC")
    private Collection<CambioATCPago> cambioATCPagoCollection;

    public TipoATC() {
    }

    public TipoATC(Long idTipoATC) {
        this.idTipoATC = idTipoATC;
    }

    public Long getIdTipoATC() {
        return idTipoATC;
    }

    public void setIdTipoATC(Long idTipoATC) {
        this.idTipoATC = idTipoATC;
    }

    public String getTipoATC() {
        return tipoATC;
    }

    public void setTipoATC(String tipoATC) {
        this.tipoATC = tipoATC;
    }

    public String getDescripcionATC() {
        return descripcionATC;
    }

    public void setDescripcionATC(String descripcionATC) {
        this.descripcionATC = descripcionATC;
    }

    @XmlTransient
    public Collection<CambioATCPago> getCambioATCPagoCollection() {
        return cambioATCPagoCollection;
    }

    public void setCambioATCPagoCollection(Collection<CambioATCPago> cambioATCPagoCollection) {
        this.cambioATCPagoCollection = cambioATCPagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoATC != null ? idTipoATC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoATC)) {
            return false;
        }
        TipoATC other = (TipoATC) object;
        if ((this.idTipoATC == null && other.idTipoATC != null) || (this.idTipoATC != null && !this.idTipoATC.equals(other.idTipoATC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avianca.entity.TipoATC[ idTipoATC=" + idTipoATC + " ]";
    }
    
}
