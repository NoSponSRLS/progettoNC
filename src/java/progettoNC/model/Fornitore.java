package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="FORNITORE")
public class Fornitore implements Serializable {
    
    @Id
    @Column(name = "PIVA")
    private String PIVA;
    
    @Column(name = "NomeFornitore")
    private String nomeFornitore;
    
   @OneToMany(mappedBy="fornitore")
    private Set<NC> NC = new HashSet(0);

    public Fornitore() {
        PIVA="";
        nomeFornitore="";
    }

    public Fornitore(String PIVA, String nomeFornitore) {
        this.PIVA = PIVA;
        this.nomeFornitore = nomeFornitore;
    }

    public String getPIVA() {
        return PIVA;
    }

    public void setPIVA(String PIVA) {
        this.PIVA = PIVA;
    }

    public String getNomeFornitore() {
        return nomeFornitore;
    }

    public void setNomeFornitore(String nomeFornitore) {
        this.nomeFornitore = nomeFornitore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.PIVA);
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
        final Fornitore other = (Fornitore) obj;
        if (!Objects.equals(this.PIVA, other.PIVA)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornitore{" + "PIVA=" + PIVA + ", nomeFornitore=" + nomeFornitore + '}';
    }
    
}
