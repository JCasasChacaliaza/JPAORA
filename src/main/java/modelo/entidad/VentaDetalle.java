/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "VENTA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDetalle.findAll", query = "SELECT v FROM VentaDetalle v")
    , @NamedQuery(name = "VentaDetalle.findByIdtel", query = "SELECT v FROM VentaDetalle v WHERE v.idtel = :idtel")
    , @NamedQuery(name = "VentaDetalle.findByCantventdet", query = "SELECT v FROM VentaDetalle v WHERE v.cantventdet = :cantventdet")})
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTEL")
    private BigDecimal idtel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTVENTDET")
    private BigInteger cantventdet;
    @JoinColumn(name = "IDPRO", referencedColumnName = "IDPRO")
    @ManyToOne(optional = false)
    private Producto idpro;
    @JoinColumn(name = "IDVENT", referencedColumnName = "IDVENT")
    @ManyToOne(optional = false)
    private Venta idvent;

    public VentaDetalle() {
    }

    public VentaDetalle(BigDecimal idtel) {
        this.idtel = idtel;
    }

    public VentaDetalle(BigDecimal idtel, BigInteger cantventdet) {
        this.idtel = idtel;
        this.cantventdet = cantventdet;
    }

    public BigDecimal getIdtel() {
        return idtel;
    }

    public void setIdtel(BigDecimal idtel) {
        this.idtel = idtel;
    }

    public BigInteger getCantventdet() {
        return cantventdet;
    }

    public void setCantventdet(BigInteger cantventdet) {
        this.cantventdet = cantventdet;
    }

    public Producto getIdpro() {
        return idpro;
    }

    public void setIdpro(Producto idpro) {
        this.idpro = idpro;
    }

    public Venta getIdvent() {
        return idvent;
    }

    public void setIdvent(Venta idvent) {
        this.idvent = idvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtel != null ? idtel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.idtel == null && other.idtel != null) || (this.idtel != null && !this.idtel.equals(other.idtel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.VentaDetalle[ idtel=" + idtel + " ]";
    }
    
}
