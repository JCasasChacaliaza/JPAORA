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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdper", query = "SELECT p FROM Persona p WHERE p.idper = :idper")
    , @NamedQuery(name = "Persona.findByNomper", query = "SELECT p FROM Persona p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Persona.findByApeper", query = "SELECT p FROM Persona p WHERE p.apeper = :apeper")
    , @NamedQuery(name = "Persona.findByDniper", query = "SELECT p FROM Persona p WHERE p.dniper = :dniper")
    , @NamedQuery(name = "Persona.findBySexper", query = "SELECT p FROM Persona p WHERE p.sexper = :sexper")
    , @NamedQuery(name = "Persona.findByCelper", query = "SELECT p FROM Persona p WHERE p.celper = :celper")
    , @NamedQuery(name = "Persona.findByTipper", query = "SELECT p FROM Persona p WHERE p.tipper = :tipper")
    , @NamedQuery(name = "Persona.findByUsuper", query = "SELECT p FROM Persona p WHERE p.usuper = :usuper")
    , @NamedQuery(name = "Persona.findByPassper", query = "SELECT p FROM Persona p WHERE p.passper = :passper")
    , @NamedQuery(name = "Persona.findByEstper", query = "SELECT p FROM Persona p WHERE p.estper = :estper")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Null
    @Column(name = "IDPER")
    private BigDecimal idper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMPER")
    private String nomper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "APEPER")
    private String apeper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPER")
    private String dniper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXPER")
    private Character sexper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CELPER")
    private String celper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPPER")
    private Character tipper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "USUPER")
    private String usuper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSPER")
    private String passper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTPER")
    private Character estper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idper")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idper")
    private List<Asignacion> asignacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idven")
    private List<Asignacion> asignacionList1;

    public Persona() {
    }

    public Persona(BigDecimal idper) {
        this.idper = idper;
    }

    public Persona(BigDecimal idper, String nomper, String apeper, String dniper, Character sexper, String celper, Character tipper, String usuper, String passper, Character estper) {
        this.idper = idper;
        this.nomper = nomper;
        this.apeper = apeper;
        this.dniper = dniper;
        this.sexper = sexper;
        this.celper = celper;
        this.tipper = tipper;
        this.usuper = usuper;
        this.passper = passper;
        this.estper = estper;
    }

    public BigDecimal getIdper() {
        return idper;
    }

    public void setIdper(BigDecimal idper) {
        this.idper = idper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public Character getSexper() {
        return sexper;
    }

    public void setSexper(Character sexper) {
        this.sexper = sexper;
    }

    public String getCelper() {
        return celper;
    }

    public void setCelper(String celper) {
        this.celper = celper;
    }

    public Character getTipper() {
        return tipper;
    }

    public void setTipper(Character tipper) {
        this.tipper = tipper;
    }

    public String getUsuper() {
        return usuper;
    }

    public void setUsuper(String usuper) {
        this.usuper = usuper;
    }

    public String getPassper() {
        return passper;
    }

    public void setPassper(String passper) {
        this.passper = passper;
    }

    public Character getEstper() {
        return estper;
    }

    public void setEstper(Character estper) {
        this.estper = estper;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList1() {
        return asignacionList1;
    }

    public void setAsignacionList1(List<Asignacion> asignacionList1) {
        this.asignacionList1 = asignacionList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idper != null ? idper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idper == null && other.idper != null) || (this.idper != null && !this.idper.equals(other.idper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Persona[ idper=" + idper + " ]";
    }
    
}
