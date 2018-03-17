package progettoNC.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ELABORAZIONE")
public class Elaborazione  implements Serializable {
    
    @Id
    @Column(name = "ID")
    private String ID;
    
    @Column(name = "DataFine")
    private String dataFine;
    
    @Column(name = "DataInizio")
    private String dataInizio;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @Column(name = "Dipendente")
    private String dipendente;
    
    @Column(name = "NC")
    private String NC;
    
    @ManyToOne
    @JoinColumn(name="NC")
    private NC nc;

    public Elaborazione() {
        ID="";
        dataFine="";
        dataInizio="";
        descrizione="";
        dipendente="";
        NC="";
    }

    public Elaborazione(String ID, String dataFine, String dataInizio, String descrizione, String dipendente, String NC) {
        this.ID = ID;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.descrizione = descrizione;
        this.dipendente = dipendente;
        this.NC = NC;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDipendente() {
        return dipendente;
    }

    public void setDipendente(String dipendente) {
        this.dipendente = dipendente;
    }

    public String getNC() {
        return NC;
    }

    public void setNC(String NC) {
        this.NC = NC;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ID);
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
        final Elaborazione other = (Elaborazione) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Elaborazione{" + "ID=" + ID + ", dataFine=" + dataFine + ", dataInizio=" + dataInizio + ", descrizione=" + descrizione + ", dipendente=" + dipendente + ", NC=" + NC + '}';
    }   
    
}
