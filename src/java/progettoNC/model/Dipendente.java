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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DIPENDENTE")
public class Dipendente implements Serializable {
    
    @Id
    @Column(name = "Matricola")
    private String matricola;
    
    @Column(name = "Nome")
    private String nome;
    
    @Column(name = "Cognome")
    private String cognome;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Ruolo")
    private String ruolo;
   
    
    @OneToMany(mappedBy="dipendente")
    private Set<Segnalazione> segnalazioni = new HashSet(0);
    
    @OneToMany(mappedBy="apertaDa")
    private Set<NC> NC = new HashSet(0);
    @ManyToMany(mappedBy="dipendentis")
     private Set<Pezzo> NCS3 = new HashSet(0);
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Reparto", nullable=false)
    private Reparto reparto;
    
    public Dipendente() {
        matricola="";
        nome="";
        cognome="";
        password="";
        ruolo="";
    }

    public Dipendente(String matricola, String nome, String cognome, String password, String ruolo, String reparto) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matricola);
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
        final Dipendente other = (Dipendente) obj;
        if (!Objects.equals(this.matricola, other.matricola)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "matricola=" + matricola + ", cognome=" + cognome + ", ruolo=" + ruolo + ", reparto=" + reparto + '}';
    }
    
    
}
