package progettoNC.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SEGNALAZIONE")
public class Segnalazione implements Serializable {
    
    @Id
    @Column(name = "IDSegnalazione")
    private String IDsegnalazione;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @Column(name = "Data")
    private String data;
    
    @Column(name = "Dipendente")
    private String dipendente;

    public Segnalazione() {
        IDsegnalazione="";
        descrizione="";
        data="";
        dipendente="";
    }

    public Segnalazione(String IDsegnalazione, String descrizione, String data, String dipendente) {
        this.IDsegnalazione = IDsegnalazione;
        this.descrizione = descrizione;
        this.data = data;
        this.dipendente = dipendente;
    }

    public String getIDsegnalazione() {
        return IDsegnalazione;
    }

    public void setIDsegnalazione(String IDsegnalazione) {
        this.IDsegnalazione = IDsegnalazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDipendente() {
        return dipendente;
    }

    public void setDipendente(String dipendente) {
        this.dipendente = dipendente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.IDsegnalazione);
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
        final Segnalazione other = (Segnalazione) obj;
        if (!Objects.equals(this.IDsegnalazione, other.IDsegnalazione)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Segnalazione{" + "IDsegnalazione=" + IDsegnalazione + ", descrizione=" + descrizione + ", data=" + data + ", dipendente=" + dipendente + '}';
    }  
    
}
