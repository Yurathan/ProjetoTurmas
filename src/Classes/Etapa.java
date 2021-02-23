/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bene
 */
@Entity
@Table(name = "etapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e")
    , @NamedQuery(name = "Etapa.findByPkEtapa", query = "SELECT e FROM Etapa e WHERE e.pkEtapa = :pkEtapa")
    , @NamedQuery(name = "Etapa.findByDescricao", query = "SELECT e FROM Etapa e WHERE e.descricao = :descricao")})
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkEtapa")
    private Integer pkEtapa;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;

    public Etapa() {
    }

    public Etapa(Integer pkEtapa) {
        this.pkEtapa = pkEtapa;
    }

    public Etapa(Integer pkEtapa, String descricao) {
        this.pkEtapa = pkEtapa;
        this.descricao = descricao;
    }

    public Integer getPkEtapa() {
        return pkEtapa;
    }

    public void setPkEtapa(Integer pkEtapa) {
        this.pkEtapa = pkEtapa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEtapa != null ? pkEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.pkEtapa == null && other.pkEtapa != null) || (this.pkEtapa != null && !this.pkEtapa.equals(other.pkEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Etapa[ pkEtapa=" + pkEtapa + " ]";
    }
    
}
