/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis.f.ronquillo
 */
@Entity
@Table(name = "DatosViajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosViajero.findAll", query = "SELECT d FROM DatosViajero d"),
    @NamedQuery(name = "DatosViajero.findByDatosViajeroId", query = "SELECT d FROM DatosViajero d WHERE d.datosViajeroId = :datosViajeroId"),
    @NamedQuery(name = "DatosViajero.findByCodigoReserva", query = "SELECT d FROM DatosViajero d WHERE d.codigoReserva = :codigoReserva"),
    @NamedQuery(name = "DatosViajero.findByNumeroIdentificacion", query = "SELECT d FROM DatosViajero d WHERE d.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "DatosViajero.findByRazonSocial", query = "SELECT d FROM DatosViajero d WHERE d.razonSocial = :razonSocial"),
    @NamedQuery(name = "DatosViajero.findByFechaViaje", query = "SELECT d FROM DatosViajero d WHERE d.fechaViaje = :fechaViaje"),
    @NamedQuery(name = "DatosViajero.findByNombreViajero", query = "SELECT d FROM DatosViajero d WHERE d.nombreViajero = :nombreViajero"),
    @NamedQuery(name = "DatosViajero.findByApellidoViajero", query = "SELECT d FROM DatosViajero d WHERE d.apellidoViajero = :apellidoViajero")})
public class DatosViajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DatosViajeroId")
    private Long datosViajeroId;
    @Size(max = 30)
    @Column(name = "CodigoReserva")
    private String codigoReserva;
    @Size(max = 30)
    @Column(name = "NumeroIdentificacion")
    private String numeroIdentificacion;
    @Size(max = 30)
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Column(name = "FechaViaje")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaViaje;
    @Size(max = 30)
    @Column(name = "NombreViajero")
    private String nombreViajero;
    @Size(max = 30)
    @Column(name = "ApellidoViajero")
    private String apellidoViajero;
    @JoinColumn(name = "CambioATC_PagosId", referencedColumnName = "IdPagos")
    @ManyToOne
    private CambioATCPago cambioATCPagosId;
    @JoinColumn(name = "FKTipoDocId", referencedColumnName = "TipoDocId")
    @ManyToOne
    private TipoDocumento fKTipoDocId;
    @OneToMany(mappedBy = "fKDatosViajeroID")
    private Collection<Itinerario> itinerarioCollection;

    public DatosViajero() {
    }

    public DatosViajero(Long datosViajeroId) {
        this.datosViajeroId = datosViajeroId;
    }

    public Long getDatosViajeroId() {
        return datosViajeroId;
    }

    public void setDatosViajeroId(Long datosViajeroId) {
        this.datosViajeroId = datosViajeroId;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getNombreViajero() {
        return nombreViajero;
    }

    public void setNombreViajero(String nombreViajero) {
        this.nombreViajero = nombreViajero;
    }

    public String getApellidoViajero() {
        return apellidoViajero;
    }

    public void setApellidoViajero(String apellidoViajero) {
        this.apellidoViajero = apellidoViajero;
    }

    public CambioATCPago getCambioATCPagosId() {
        return cambioATCPagosId;
    }

    public void setCambioATCPagosId(CambioATCPago cambioATCPagosId) {
        this.cambioATCPagosId = cambioATCPagosId;
    }

    public TipoDocumento getFKTipoDocId() {
        return fKTipoDocId;
    }

    public void setFKTipoDocId(TipoDocumento fKTipoDocId) {
        this.fKTipoDocId = fKTipoDocId;
    }

    @XmlTransient
    public Collection<Itinerario> getItinerarioCollection() {
        return itinerarioCollection;
    }

    public void setItinerarioCollection(Collection<Itinerario> itinerarioCollection) {
        this.itinerarioCollection = itinerarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosViajeroId != null ? datosViajeroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosViajero)) {
            return false;
        }
        DatosViajero other = (DatosViajero) object;
        if ((this.datosViajeroId == null && other.datosViajeroId != null) || (this.datosViajeroId != null && !this.datosViajeroId.equals(other.datosViajeroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avianca.entity.DatosViajero[ datosViajeroId=" + datosViajeroId + " ]";
    }
    
}
