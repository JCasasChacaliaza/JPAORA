/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "SUCURSAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdsuc", query = "SELECT s FROM Sucursal s WHERE s.idsuc = :idsuc")
    , @NamedQuery(name = "Sucursal.findByTelsuc", query = "SELECT s FROM Sucursal s WHERE s.telsuc = :telsuc")
    , @NamedQuery(name = "Sucursal.findByDiresuc", query = "SELECT s FROM Sucursal s WHERE s.diresuc = :diresuc")
    , @NamedQuery(name = "Sucursal.findByProsuc", query = "SELECT s FROM Sucursal s WHERE s.prosuc = :prosuc")
    , @NamedQuery(name = "Sucursal.findByEstsuc", query = "SELECT s FROM Sucursal s WHERE s.estsuc = :estsuc")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSUC")
    private BigDecimal idsuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "TELSUC")
    private String telsuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DIRESUC")
    private String diresuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "PROSUC")
    private String prosuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTSUC")
    private Character estsuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsuc")
    private List<Asignacion> asignacionList;

    public Sucursal() {
    }

    public Sucursal(BigDecimal idsuc) {
        this.idsuc = idsuc;
    }

    public Sucursal(BigDecimal idsuc, String telsuc, String diresuc, String prosuc, Character estsuc) {
        this.idsuc = idsuc;
        this.telsuc = telsuc;
        this.diresuc = diresuc;
        this.prosuc = prosuc;
        this.estsuc = estsuc;
    }

    public BigDecimal getIdsuc() {
        return idsuc;
    }

    public void setIdsuc(BigDecimal idsuc) {
        this.idsuc = idsuc;
    }

    public String getTelsuc() {
        return telsuc;
    }

    public void setTelsuc(String telsuc) {
        this.telsuc = telsuc;
    }

    public String getDiresuc() {
        return diresuc;
    }

    public void setDiresuc(String diresuc) {
        this.diresuc = diresuc;
    }

    public String getProsuc() {
        return prosuc;
    }

    public void setProsuc(String prosuc) {
        this.prosuc = prosuc;
    }

    public Character getEstsuc() {
        return estsuc;
    }

    public void setEstsuc(Character estsuc) {
        this.estsuc = estsuc;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuc != null ? idsuc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsuc == null && other.idsuc != null) || (this.idsuc != null && !this.idsuc.equals(other.idsuc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Sucursal[ idsuc=" + idsuc + " ]";
    }
    
}
