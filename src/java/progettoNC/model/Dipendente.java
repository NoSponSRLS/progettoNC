package progettoNC.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    
    @Column(name = "Reparto")
    private String reparto;

    public Dipendente() {
        matricola="";
        nome="";
        cognome="";
        password="";
        ruolo="";
        reparto="";
    }

    public Dipendente(String matricola, String nome, String cognome, String password, String ruolo, String reparto) {
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

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
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
