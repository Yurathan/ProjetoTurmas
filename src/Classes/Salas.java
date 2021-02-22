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
@Table(name = "salas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s")
    , @NamedQuery(name = "Salas.findByPkSala", query = "SELECT s FROM Salas s WHERE s.pkSala = :pkSala")
    , @NamedQuery(name = "Salas.findByDescri\u00e7\u00e3o", query = "SELECT s FROM Salas s WHERE s.descri\u00e7\u00e3o = :descri\u00e7\u00e3o")
    , @NamedQuery(name = "Salas.findByLota\u00e7\u00e3o", query = "SELECT s FROM Salas s WHERE s.lota\u00e7\u00e3o = :lota\u00e7\u00e3o")})
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkSala")
    private Integer pkSala;
    @Basic(optional = false)
    @Column(name = "Descri\u00e7\u00e3o")
    private String descrição;
    @Basic(optional = false)
    @Column(name = "Lota\u00e7\u00e3o")
    private int lotação;

    public Salas() {
    }

    public Salas(Integer pkSala) {
        this.pkSala = pkSala;
    }

    public Salas(Integer pkSala, String descrição, int lotação) {
        this.pkSala = pkSala;
        this.descrição = descrição;
        this.lotação = lotação;
    }

    public Integer getPkSala() {
        return pkSala;
    }

    public void setPkSala(Integer pkSala) {
        this.pkSala = pkSala;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getLotação() {
        return lotação;
    }

    public void setLotação(int lotação) {
        this.lotação = lotação;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkSala != null ? pkSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.pkSala == null && other.pkSala != null) || (this.pkSala != null && !this.pkSala.equals(other.pkSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Salas[ pkSala=" + pkSala + " ]";
    }
    
}
