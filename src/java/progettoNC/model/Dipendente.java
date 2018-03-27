package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Column(name = "Matricola", length = 10)
    private String matricola;
    
    @Column(name = "Nome")
    private String nome;
    
    @Column(name = "Cognome")
    private String cognome;
    
    @Column(name = "Password")
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Ruolo")
    private Ruolo ruolo;
    
    @OneToMany(mappedBy="dipendente")
    private Set<Segnalazione> segnalazioni = new HashSet(0);
    
    @OneToMany(mappedBy="apertaDa")
    private Set<NC> apertaDa = new HashSet(0);
    
    @ManyToMany(mappedBy="teamNC")
     private Set<NC> teams = new HashSet(0);
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Reparto", nullable=false)
    private Reparto reparto;
    
    public Dipendente() {
    }

    public Dipendente(String matricola, String nome, String cognome, String password, Ruolo ruolo, Reparto reparto) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.ruolo = ruolo;
        this.reparto = reparto;
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

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setSegnalazioni(Set<Segnalazione> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    public void setApertaDa(Set<NC> apertaDa) {
        this.apertaDa = apertaDa;
    }

    public void setTeams(Set<NC> teams) {
        this.teams = teams;
    }

    public Set<Segnalazione> getSegnalazioni() {
        return segnalazioni;
    }

    public Set<NC> getApertaDa() {
        return apertaDa;
    }

    public Set<NC> getTeams() {
        return teams;
    }

    public void setRuolo(Ruolo ruolo) {
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
    
}//Matricola