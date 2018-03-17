package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="TIPO")
public class Tipo implements Serializable{
    
    @Id
    @Column(name = "Nome")
    private String nome;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="TIPI_NC", joinColumns = { 
        @JoinColumn(name="Nome", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="IDNC", nullable=false, updatable=false) })
    private Set<NC> NCS2 = new HashSet(0);
    
    public Tipo() {
        nome="";
        descrizione="";
    }
    
    public Tipo(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
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
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tipo{" + "nome=" + nome + ", descrizione=" + descrizione + '}';
    }
 
}
