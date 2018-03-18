package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REPARTI")
public class Reparto  implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="IDReparto")
    private int id;
    
    @Column(name="Nome")
    private String nome;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="reparto")
    private Set<Dipendente> dipendenti = new HashSet(0);
    
    @OneToMany(mappedBy="reparto")
    private Set<NC> NC = new HashSet(0);

    public Reparto() {
    }

    public Reparto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setDipendenti(Set<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void setNC(Set<NC> NC) {
        this.NC = NC;
    }

    public Set<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public Set<NC> getNC() {
        return NC;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        final Reparto other = (Reparto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reparti{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}//Reparto