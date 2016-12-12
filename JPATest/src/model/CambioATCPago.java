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
@Table(name = "CambioATC_Pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CambioATCPago.findAll", query = "SELECT c FROM CambioATCPago c"),
    @NamedQuery(name = "CambioATCPago.findByIdPagos", query = "SELECT c FROM CambioATCPago c WHERE c.idPagos = :idPagos"),
    @NamedQuery(name = "CambioATCPago.findByFecha", query = "SELECT c FROM CambioATCPago c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CambioATCPago.findByPnr", query = "SELECT c FROM CambioATCPago c WHERE c.pnr = :pnr"),
    @NamedQuery(name = "CambioATCPago.findByEstado", query = "SELECT c FROM CambioATCPago c WHERE c.estado = :estado"),
    @NamedQuery(name = "CambioATCPago.findByOfficeID", query = "SELECT c FROM CambioATCPago c WHERE c.officeID = :officeID"),
    @NamedQuery(name = "CambioATCPago.findByPagadorNombre", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorNombre = :pagadorNombre"),
    @NamedQuery(name = "CambioATCPago.findByPagadorApellido", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorApellido = :pagadorApellido"),
    @NamedQuery(name = "CambioATCPago.findByPagadorTipoDoc", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorTipoDoc = :pagadorTipoDoc"),
    @NamedQuery(name = "CambioATCPago.findByPagadorNumDoc", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorNumDoc = :pagadorNumDoc"),
    @NamedQuery(name = "CambioATCPago.findByPagadorCorreo", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorCorreo = :pagadorCorreo"),
    @NamedQuery(name = "CambioATCPago.findByPagadorTelefono", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorTelefono = :pagadorTelefono"),
    @NamedQuery(name = "CambioATCPago.findByPagadorPais", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorPais = :pagadorPais"),
    @NamedQuery(name = "CambioATCPago.findByPagadorCiudad", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorCiudad = :pagadorCiudad"),
    @NamedQuery(name = "CambioATCPago.findByPagadorDireccion", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorDireccion = :pagadorDireccion"),
    @NamedQuery(name = "CambioATCPago.findByPagadorZipCode", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorZipCode = :pagadorZipCode"),
    @NamedQuery(name = "CambioATCPago.findByAceptarTerminosCondiciones", query = "SELECT c FROM CambioATCPago c WHERE c.aceptarTerminosCondiciones = :aceptarTerminosCondiciones"),
    @NamedQuery(name = "CambioATCPago.findByPagadorPaisEmisionTC", query = "SELECT c FROM CambioATCPago c WHERE c.pagadorPaisEmisionTC = :pagadorPaisEmisionTC"),
    @NamedQuery(name = "CambioATCPago.findByMedioPagoID", query = "SELECT c FROM CambioATCPago c WHERE c.medioPagoID = :medioPagoID"),
    @NamedQuery(name = "CambioATCPago.findByFranquiciaID", query = "SELECT c FROM CambioATCPago c WHERE c.franquiciaID = :franquiciaID"),
    @NamedQuery(name = "CambioATCPago.findByValorPago", query = "SELECT c FROM CambioATCPago c WHERE c.valorPago = :valorPago"),
    @NamedQuery(name = "CambioATCPago.findByValorDevuelto", query = "SELECT c FROM CambioATCPago c WHERE c.valorDevuelto = :valorDevuelto")})
public class CambioATCPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPagos")
    private Long idPagos;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "PNR")
    private String pnr;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 30)
    @Column(name = "OfficeID")
    private String officeID;
    @Size(max = 30)
    @Column(name = "Pagador_Nombre")
    private String pagadorNombre;
    @Size(max = 30)
    @Column(name = "Pagador_Apellido")
    private String pagadorApellido;
    @Size(max = 30)
    @Column(name = "Pagador_TipoDoc")
    private String pagadorTipoDoc;
    @Size(max = 30)
    @Column(name = "Pagador_NumDoc")
    private String pagadorNumDoc;
    @Size(max = 30)
    @Column(name = "Pagador_Correo")
    private String pagadorCorreo;
    @Size(max = 30)
    @Column(name = "Pagador_Telefono")
    private String pagadorTelefono;
    @Size(max = 30)
    @Column(name = "Pagador_Pais")
    private String pagadorPais;
    @Size(max = 30)
    @Column(name = "Pagador_Ciudad")
    private String pagadorCiudad;
    @Size(max = 30)
    @Column(name = "Pagador_Direccion")
    private String pagadorDireccion;
    @Size(max = 30)
    @Column(name = "Pagador_ZipCode")
    private String pagadorZipCode;
    @Size(max = 1)
    @Column(name = "AceptarTerminosCondiciones")
    private String aceptarTerminosCondiciones;
    @Size(max = 10)
    @Column(name = "PagadorPaisEmisionTC")
    private String pagadorPaisEmisionTC;
    @Column(name = "MedioPagoID")
    private Long medioPagoID;
    @Column(name = "FranquiciaID")
    private Long franquiciaID;
    @Column(name = "ValorPago")
    private Long valorPago;
    @Column(name = "ValorDevuelto")
    private Long valorDevuelto;
    @OneToMany(mappedBy = "cambioATCPagosId")
    private Collection<DatosViajero> datosViajeroCollection;
    @JoinColumn(name = "FK_IdTipoATC", referencedColumnName = "IdTipoATC")
    @ManyToOne
    private TipoATC fKIdTipoATC;

    public CambioATCPago() {
    }

    public CambioATCPago(Long idPagos) {
        this.idPagos = idPagos;
    }

    public Long getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Long idPagos) {
        this.idPagos = idPagos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOfficeID() {
        return officeID;
    }

    public void setOfficeID(String officeID) {
        this.officeID = officeID;
    }

    public String getPagadorNombre() {
        return pagadorNombre;
    }

    public void setPagadorNombre(String pagadorNombre) {
        this.pagadorNombre = pagadorNombre;
    }

    public String getPagadorApellido() {
        return pagadorApellido;
    }

    public void setPagadorApellido(String pagadorApellido) {
        this.pagadorApellido = pagadorApellido;
    }

    public String getPagadorTipoDoc() {
        return pagadorTipoDoc;
    }

    public void setPagadorTipoDoc(String pagadorTipoDoc) {
        this.pagadorTipoDoc = pagadorTipoDoc;
    }

    public String getPagadorNumDoc() {
        return pagadorNumDoc;
    }

    public void setPagadorNumDoc(String pagadorNumDoc) {
        this.pagadorNumDoc = pagadorNumDoc;
    }

    public String getPagadorCorreo() {
        return pagadorCorreo;
    }

    public void setPagadorCorreo(String pagadorCorreo) {
        this.pagadorCorreo = pagadorCorreo;
    }

    public String getPagadorTelefono() {
        return pagadorTelefono;
    }

    public void setPagadorTelefono(String pagadorTelefono) {
        this.pagadorTelefono = pagadorTelefono;
    }

    public String getPagadorPais() {
        return pagadorPais;
    }

    public void setPagadorPais(String pagadorPais) {
        this.pagadorPais = pagadorPais;
    }

    public String getPagadorCiudad() {
        return pagadorCiudad;
    }

    public void setPagadorCiudad(String pagadorCiudad) {
        this.pagadorCiudad = pagadorCiudad;
    }

    public String getPagadorDireccion() {
        return pagadorDireccion;
    }

    public void setPagadorDireccion(String pagadorDireccion) {
        this.pagadorDireccion = pagadorDireccion;
    }

    public String getPagadorZipCode() {
        return pagadorZipCode;
    }

    public void setPagadorZipCode(String pagadorZipCode) {
        this.pagadorZipCode = pagadorZipCode;
    }

    public String getAceptarTerminosCondiciones() {
        return aceptarTerminosCondiciones;
    }

    public void setAceptarTerminosCondiciones(String aceptarTerminosCondiciones) {
        this.aceptarTerminosCondiciones = aceptarTerminosCondiciones;
    }

    public String getPagadorPaisEmisionTC() {
        return pagadorPaisEmisionTC;
    }

    public void setPagadorPaisEmisionTC(String pagadorPaisEmisionTC) {
        this.pagadorPaisEmisionTC = pagadorPaisEmisionTC;
    }

    public Long getMedioPagoID() {
        return medioPagoID;
    }

    public void setMedioPagoID(Long medioPagoID) {
        this.medioPagoID = medioPagoID;
    }

    public Long getFranquiciaID() {
        return franquiciaID;
    }

    public void setFranquiciaID(Long franquiciaID) {
        this.franquiciaID = franquiciaID;
    }

    public Long getValorPago() {
        return valorPago;
    }

    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }

    public Long getValorDevuelto() {
        return valorDevuelto;
    }

    public void setValorDevuelto(Long valorDevuelto) {
        this.valorDevuelto = valorDevuelto;
    }

    @XmlTransient
    public Collection<DatosViajero> getDatosViajeroCollection() {
        return datosViajeroCollection;
    }

    public void setDatosViajeroCollection(Collection<DatosViajero> datosViajeroCollection) {
        this.datosViajeroCollection = datosViajeroCollection;
    }

    public TipoATC getFKIdTipoATC() {
        return fKIdTipoATC;
    }

    public void setFKIdTipoATC(TipoATC fKIdTipoATC) {
        this.fKIdTipoATC = fKIdTipoATC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambioATCPago)) {
            return false;
        }
        CambioATCPago other = (CambioATCPago) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avianca.entity.CambioATCPago[ idPagos=" + idPagos + " ]";
    }
    
}
