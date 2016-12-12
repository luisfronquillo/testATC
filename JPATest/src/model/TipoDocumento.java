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
@Table(name = "TipoDocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocId", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocId = :tipoDocId"),
    @NamedQuery(name = "TipoDocumento.findByDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.documento = :documento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TipoDocId")
    private Long tipoDocId;
    @Size(max = 30)
    @Column(name = "Documento")
    private String documento;
    @OneToMany(mappedBy = "fKTipoDocId")
    private Collection<DatosViajero> datosViajeroCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Long tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public Long getTipoDocId() {
        return tipoDocId;
    }

    public void setTipoDocId(Long tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @XmlTransient
    public Collection<DatosViajero> getDatosViajeroCollection() {
        return datosViajeroCollection;
    }

    public void setDatosViajeroCollection(Collection<DatosViajero> datosViajeroCollection) {
        this.datosViajeroCollection = datosViajeroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocId != null ? tipoDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocId == null && other.tipoDocId != null) || (this.tipoDocId != null && !this.tipoDocId.equals(other.tipoDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avianca.entity.TipoDocumento[ tipoDocId=" + tipoDocId + " ]";
    }
    
}
