package com.waltermaas.jndcci.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author wmaas
 */
@Entity
@Table(name = "duiknieuws")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Duiknieuws.findAll", query = "SELECT d FROM Duiknieuws d"),
  @NamedQuery(name = "Duiknieuws.findByKeyid", query = "SELECT d FROM Duiknieuws d WHERE d.keyid = :keyid"),
  @NamedQuery(name = "Duiknieuws.findByDatumnews", query = "SELECT d FROM Duiknieuws d WHERE d.datumnews = :datumnews"),
  @NamedQuery(name = "Duiknieuws.findByTaal", query = "SELECT d FROM Duiknieuws d WHERE d.taal = :taal")})
public class Duiknieuws implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "keyid")
  private Integer keyid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "datumnews")
  @Temporal(TemporalType.DATE)
  private Date datumnews;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "taal")
  private String taal;
  @Lob
  @Size(max = 65535)
  @Column(name = "tekst")
  private String tekst;

  public Duiknieuws() {
  }

  public Duiknieuws(Integer keyid) {
    this.keyid = keyid;
  }

  public Duiknieuws(Integer keyid, Date datumnews, String taal) {
    this.keyid = keyid;
    this.datumnews = datumnews;
    this.taal = taal;
  }

  public Integer getKeyid() {
    return keyid;
  }

  public void setKeyid(Integer keyid) {
    this.keyid = keyid;
  }

  public Date getDatumnews() {
    return datumnews;
  }

  public void setDatumnews(Date datumnews) {
    this.datumnews = datumnews;
  }

  public String getTaal() {
    return taal;
  }

  public void setTaal(String taal) {
    this.taal = taal;
  }

  public String getTekst() {
    return tekst;
  }

  public void setTekst(String tekst) {
    this.tekst = tekst;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (keyid != null ? keyid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Duiknieuws)) {
      return false;
    }
    Duiknieuws other = (Duiknieuws) object;
    if ((this.keyid == null && other.keyid != null) || (this.keyid != null && !this.keyid.equals(other.keyid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "keyid=" + keyid;
  }
  
}
