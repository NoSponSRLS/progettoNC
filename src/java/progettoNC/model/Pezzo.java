package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name="IDPezzo")
    private int id;
    
    @Column(name="Categoria")
    private String nomecategoria;
    
    @ManyToOne
    @JoinColumn(name="Categoria")
    private Categoria categorie;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="NC_PEZZI", joinColumns = { 
        @JoinColumn(name="IDPezzo", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="IDNC", nullable=false, updatable=false) })
    private Set<NC> pezziNC = new HashSet(0);
    
    public Pezzo(int id, String nomecategoria) {
        this.id = id;
        this.nomecategoria = nomecategoria;
    }

    public Pezzo() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecategoria() {
        return nomecategoria;
    }

    public void setNomecategoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
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
        return "Pezzi{" + "id=" + id + ", nomecategoria=" + nomecategoria + '}';
    }

}
