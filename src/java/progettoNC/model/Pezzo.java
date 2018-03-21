package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEZZI")
public class Pezzo implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="IDPezzo")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="Categoria", nullable = false)
    private Categoria categoria;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="NC_PEZZI", joinColumns = { 
        @JoinColumn(name="IDPezzo", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="IDNC", nullable=false, updatable=false) })
    private Set<NC> pezziNC = new HashSet(0);

    public Pezzo(int id, Categoria categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Pezzo() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Set<NC> getPezziNC() {
        return pezziNC;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPezziNC(Set<NC> pezziNC) {
        this.pezziNC = pezziNC;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pezzo other = (Pezzo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pezzo{" + "id=" + id + ", categoria=" + categoria + ", pezziNC=" + pezziNC + '}';
    }
    
}//Pezzo