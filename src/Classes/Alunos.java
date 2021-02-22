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
@Table(name = "alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a")
    , @NamedQuery(name = "Alunos.findByPkAluno", query = "SELECT a FROM Alunos a WHERE a.pkAluno = :pkAluno")
    , @NamedQuery(name = "Alunos.findByNomeCompleto", query = "SELECT a FROM Alunos a WHERE a.nomeCompleto = :nomeCompleto")})
public class Alunos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkAluno")
    private Integer pkAluno;
    @Basic(optional = false)
    @Column(name = "NomeCompleto")
    private String nomeCompleto;

    public Alunos() {
    }

    public Alunos(Integer pkAluno) {
        this.pkAluno = pkAluno;
    }

    public Alunos(Integer pkAluno, String nomeCompleto) {
        this.pkAluno = pkAluno;
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getPkAluno() {
        return pkAluno;
    }

    public void setPkAluno(Integer pkAluno) {
        this.pkAluno = pkAluno;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAluno != null ? pkAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.pkAluno == null && other.pkAluno != null) || (this.pkAluno != null && !this.pkAluno.equals(other.pkAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Alunos[ pkAluno=" + pkAluno + " ]";
    }
    
}
