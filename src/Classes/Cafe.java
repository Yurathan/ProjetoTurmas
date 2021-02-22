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
@Table(name = "cafe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cafe.findAll", query = "SELECT c FROM Cafe c")
    , @NamedQuery(name = "Cafe.findByPkcafe", query = "SELECT c FROM Cafe c WHERE c.pkcafe = :pkcafe")
    , @NamedQuery(name = "Cafe.findByDescricao", query = "SELECT c FROM Cafe c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Cafe.findByLotacao", query = "SELECT c FROM Cafe c WHERE c.lotacao = :lotacao")})
public class Cafe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkcafe")
    private Integer pkcafe;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "Lotacao")
    private int lotacao;

    public Cafe() {
    }

    public Cafe(Integer pkcafe) {
        this.pkcafe = pkcafe;
    }

    public Cafe(Integer pkcafe, String descricao, int lotacao) {
        this.pkcafe = pkcafe;
        this.descricao = descricao;
        this.lotacao = lotacao;
    }

    public Integer getPkcafe() {
        return pkcafe;
    }

    public void setPkcafe(Integer pkcafe) {
        this.pkcafe = pkcafe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcafe != null ? pkcafe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cafe)) {
            return false;
        }
        Cafe other = (Cafe) object;
        if ((this.pkcafe == null && other.pkcafe != null) || (this.pkcafe != null && !this.pkcafe.equals(other.pkcafe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Cafe[ pkcafe=" + pkcafe + " ]";
    }
    
}
