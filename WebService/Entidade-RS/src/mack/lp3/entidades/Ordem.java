package mack.lp3.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Morelatto
 */
@Entity
@Table(name = "ORDEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordem.findAll", query = "SELECT o FROM Ordem o"),
    @NamedQuery(name = "Ordem.findByIdOrdem", query = "SELECT o FROM Ordem o WHERE o.idOrdem = :idOrdem"),
    @NamedQuery(name = "Ordem.findByDescricao", query = "SELECT o FROM Ordem o WHERE o.descricao = :descricao")})
public class Ordem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEM")
    private Integer idOrdem;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;

    public Ordem() {
    }

    public Ordem(Integer idOrdem) {
        this.idOrdem = idOrdem;
    }

    public Ordem(Integer idOrdem, String descricao) {
        this.idOrdem = idOrdem;
        this.descricao = descricao;
    }

    public Integer getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(Integer idOrdem) {
        this.idOrdem = idOrdem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdem != null ? idOrdem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordem)) {
            return false;
        }
        Ordem other = (Ordem) object;
        if ((this.idOrdem == null && other.idOrdem != null) || (this.idOrdem != null && !this.idOrdem.equals(other.idOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mack.lp3.entidades.Ordem[ idOrdem=" + idOrdem + " ]";
    }
    
}
