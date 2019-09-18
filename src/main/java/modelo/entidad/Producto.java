/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdpro", query = "SELECT p FROM Producto p WHERE p.idpro = :idpro")
    , @NamedQuery(name = "Producto.findByNompro", query = "SELECT p FROM Producto p WHERE p.nompro = :nompro")
    , @NamedQuery(name = "Producto.findByPrepro", query = "SELECT p FROM Producto p WHERE p.prepro = :prepro")
    , @NamedQuery(name = "Producto.findByCatpro", query = "SELECT p FROM Producto p WHERE p.catpro = :catpro")
    , @NamedQuery(name = "Producto.findByEstpro", query = "SELECT p FROM Producto p WHERE p.estpro = :estpro")
    , @NamedQuery(name = "Producto.findByCantpro", query = "SELECT p FROM Producto p WHERE p.cantpro = :cantpro")
    , @NamedQuery(name = "Producto.findByFechingpro", query = "SELECT p FROM Producto p WHERE p.fechingpro = :fechingpro")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRO")
    private BigDecimal idpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMPRO")
    private String nompro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PREPRO")
    private BigDecimal prepro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CATPRO")
    private String catpro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTPRO")
    private Character estpro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTPRO")
    private BigInteger cantpro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHINGPRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechingpro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpro")
    private List<VentaDetalle> ventaDetalleList;

    public Producto() {
    }

    public Producto(BigDecimal idpro) {
        this.idpro = idpro;
    }

    public Producto(BigDecimal idpro, String nompro, BigDecimal prepro, String catpro, Character estpro, BigInteger cantpro, Date fechingpro) {
        this.idpro = idpro;
        this.nompro = nompro;
        this.prepro = prepro;
        this.catpro = catpro;
        this.estpro = estpro;
        this.cantpro = cantpro;
        this.fechingpro = fechingpro;
    }

    public BigDecimal getIdpro() {
        return idpro;
    }

    public void setIdpro(BigDecimal idpro) {
        this.idpro = idpro;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public BigDecimal getPrepro() {
        return prepro;
    }

    public void setPrepro(BigDecimal prepro) {
        this.prepro = prepro;
    }

    public String getCatpro() {
        return catpro;
    }

    public void setCatpro(String catpro) {
        this.catpro = catpro;
    }

    public Character getEstpro() {
        return estpro;
    }

    public void setEstpro(Character estpro) {
        this.estpro = estpro;
    }

    public BigInteger getCantpro() {
        return cantpro;
    }

    public void setCantpro(BigInteger cantpro) {
        this.cantpro = cantpro;
    }

    public Date getFechingpro() {
        return fechingpro;
    }

    public void setFechingpro(Date fechingpro) {
        this.fechingpro = fechingpro;
    }

    @XmlTransient
    public List<VentaDetalle> getVentaDetalleList() {
        return ventaDetalleList;
    }

    public void setVentaDetalleList(List<VentaDetalle> ventaDetalleList) {
        this.ventaDetalleList = ventaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpro != null ? idpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idpro == null && other.idpro != null) || (this.idpro != null && !this.idpro.equals(other.idpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Producto[ idpro=" + idpro + " ]";
    }
    
}
