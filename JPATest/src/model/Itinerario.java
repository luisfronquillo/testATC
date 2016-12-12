/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis.f.ronquillo
 */
@Entity
@Table(name = "Itinerario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i"),
    @NamedQuery(name = "Itinerario.findByTrayectosId", query = "SELECT i FROM Itinerario i WHERE i.trayectosId = :trayectosId"),
    @NamedQuery(name = "Itinerario.findByOrigen", query = "SELECT i FROM Itinerario i WHERE i.origen = :origen"),
    @NamedQuery(name = "Itinerario.findByDestino", query = "SELECT i FROM Itinerario i WHERE i.destino = :destino"),
    @NamedQuery(name = "Itinerario.findByFechaVuelo", query = "SELECT i FROM Itinerario i WHERE i.fechaVuelo = :fechaVuelo"),
    @NamedQuery(name = "Itinerario.findByNumeroVuelo", query = "SELECT i FROM Itinerario i WHERE i.numeroVuelo = :numeroVuelo")})
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrayectosId")
    private Long trayectosId;
    @Size(max = 30)
    @Column(name = "Origen")
    private String origen;
    @Size(max = 30)
    @Column(name = "Destino")
    private String destino;
    @Column(name = "FechaVuelo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVuelo;
    @Size(max = 30)
    @Column(name = "NumeroVuelo")
    private String numeroVuelo;
    @JoinColumn(name = "FK_DatosViajeroID", referencedColumnName = "DatosViajeroId")
    @ManyToOne
    private DatosViajero fKDatosViajeroID;

    public Itinerario() {
    }

    public Itinerario(Long trayectosId) {
        this.trayectosId = trayectosId;
    }

    public Long getTrayectosId() {
        return trayectosId;
    }

    public void setTrayectosId(Long trayectosId) {
        this.trayectosId = trayectosId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public DatosViajero getFKDatosViajeroID() {
        return fKDatosViajeroID;
    }

    public void setFKDatosViajeroID(DatosViajero fKDatosViajeroID) {
        this.fKDatosViajeroID = fKDatosViajeroID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trayectosId != null ? trayectosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.trayectosId == null && other.trayectosId != null) || (this.trayectosId != null && !this.trayectosId.equals(other.trayectosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avianca.entity.Itinerario[ trayectosId=" + trayectosId + " ]";
    }
    
}
