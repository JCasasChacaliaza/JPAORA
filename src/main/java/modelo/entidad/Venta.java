/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Usuario
 */
@Entity
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdvent", query = "SELECT v FROM Venta v WHERE v.idvent = :idvent")
    , @NamedQuery(name = "Venta.findByNomcli", query = "SELECT v FROM Venta v WHERE v.nomcli = :nomcli")
    , @NamedQuery(name = "Venta.findByDnicli", query = "SELECT v FROM Venta v WHERE v.dnicli = :dnicli")
    , @NamedQuery(name = "Venta.findByFecvent", query = "SELECT v FROM Venta v WHERE v.fecvent = :fecvent")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVENT")
    private BigDecimal idvent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMCLI")
    private String nomcli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DNICLI")
    private String dnicli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECVENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvent;
    @JoinColumn(name = "IDPER", referencedColumnName = "IDPER")
    @ManyToOne(optional = false)
    private Persona idper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvent")
    private List<VentaDetalle> ventaDetalleList;

    public Venta() {
    }

    public Venta(BigDecimal idvent) {
        this.idvent = idvent;
    }

    public Venta(BigDecimal idvent, String nomcli, String dnicli, Date fecvent) {
        this.idvent = idvent;
        this.nomcli = nomcli;
        this.dnicli = dnicli;
        this.fecvent = fecvent;
    }

    public BigDecimal getIdvent() {
        return idvent;
    }

    public void setIdvent(BigDecimal idvent) {
        this.idvent = idvent;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getDnicli() {
        return dnicli;
    }

    public void setDnicli(String dnicli) {
        this.dnicli = dnicli;
    }

    public Date getFecvent() {
        return fecvent;
    }

    public void setFecvent(Date fecvent) {
        this.fecvent = fecvent;
    }

    public Persona getIdper() {
        return idper;
    }

    public void setIdper(Persona idper) {
        this.idper = idper;
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
        hash += (idvent != null ? idvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idvent == null && other.idvent != null) || (this.idvent != null && !this.idvent.equals(other.idvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Venta[ idvent=" + idvent + " ]";
    }
    
}
