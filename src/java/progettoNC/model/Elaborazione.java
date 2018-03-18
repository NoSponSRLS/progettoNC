package progettoNC.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ELABORAZIONE")
public class Elaborazione  implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int ID;
    
    @Column(name = "DataFine")
    private String dataFine;
    
    @Column(name = "DataInizio")
    private String dataInizio;
    
    @Column(name = "Descrizione")
    private String descrizione;
    
    @ManyToOne
    @JoinColumn(name = "Dipendente")
    private Dipendente dipendente;
    
    @ManyToOne
    @JoinColumn(name="NC")
    private NC nc;

    public Elaborazione() {
    }

    public Elaborazione(int ID, String dataFine, String dataInizio, String descrizione, Dipendente dipendente, NC nc) {
        this.ID = ID;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.descrizione = descrizione;
        this.dipendente = dipendente;
        this.nc = nc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public void setNc(NC nc) {
        this.nc = nc;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public NC getNc() {
        return nc;
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
        return "Elaborazione{" + "ID=" + ID + ", dataFine=" + dataFine + ", dataInizio=" + dataInizio + ", descrizione=" + descrizione + ", dipendente=" + dipendente + ", NC=" + nc + '}';
    }   
    
}//Elaborazione
