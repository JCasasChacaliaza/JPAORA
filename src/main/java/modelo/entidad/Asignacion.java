/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ASIGNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findByIdasi", query = "SELECT a FROM Asignacion a WHERE a.idasi = :idasi")
    , @NamedQuery(name = "Asignacion.findByEstasi", query = "SELECT a FROM Asignacion a WHERE a.estasi = :estasi")
    , @NamedQuery(name = "Asignacion.findByGruasig", query = "SELECT a FROM Asignacion a WHERE a.gruasig = :gruasig")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDASI")
    private BigDecimal idasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTASI")
    private Character estasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRUASIG")
    private Character gruasig;
    @JoinColumn(name = "IDPER", referencedColumnName = "IDPER")
    @ManyToOne(optional = false)
    private Persona idper;
    @JoinColumn(name = "IDVEN", referencedColumnName = "IDPER")
    @ManyToOne(optional = false)
    private Persona idven;
    @JoinColumn(name = "IDSUC", referencedColumnName = "IDSUC")
    @ManyToOne(optional = false)
    private Sucursal idsuc;

    public Asignacion() {
    }

    public Asignacion(BigDecimal idasi) {
        this.idasi = idasi;
    }

    public Asignacion(BigDecimal idasi, Character estasi, Character gruasig) {
        this.idasi = idasi;
        this.estasi = estasi;
        this.gruasig = gruasig;
    }

    public BigDecimal getIdasi() {
        return idasi;
    }

    public void setIdasi(BigDecimal idasi) {
        this.idasi = idasi;
    }

    public Character getEstasi() {
        return estasi;
    }

    public void setEstasi(Character estasi) {
        this.estasi = estasi;
    }

    public Character getGruasig() {
        return gruasig;
    }

    public void setGruasig(Character gruasig) {
        this.gruasig = gruasig;
    }

    public Persona getIdper() {
        return idper;
    }

    public void setIdper(Persona idper) {
        this.idper = idper;
    }

    public Persona getIdven() {
        return idven;
    }

    public void setIdven(Persona idven) {
        this.idven = idven;
    }

    public Sucursal getIdsuc() {
        return idsuc;
    }

    public void setIdsuc(Sucursal idsuc) {
        this.idsuc = idsuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasi != null ? idasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idasi == null && other.idasi != null) || (this.idasi != null && !this.idasi.equals(other.idasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Asignacion[ idasi=" + idasi + " ]";
    }
    
}
