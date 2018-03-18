package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIE")
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="IDCategoria", length = 5)
    private int id;
    
    @Column(name="Descrizione")
    private String descrizione;
    
    @OneToMany(mappedBy="categorie")
    private Set<Pezzo> pezzi = new HashSet(0);

    public Categoria() {
    }

    public Categoria(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public void setPezzi(Set<Pezzo> pezzi) {
        this.pezzi = pezzi;
    }

    public Set<Pezzo> getPezzi() {
        return pezzi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", descrizione=" + descrizione + '}';
    }
    
}//Categoria