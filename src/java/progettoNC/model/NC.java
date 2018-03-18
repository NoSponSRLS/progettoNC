package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="NC")
public class NC implements Serializable {
    
    @Id
    @Column(name="IDNC")
    private int id;
    
    @Column(name="Stato")
    private String stato;
    
    @Column(name="DescrizioneProblema")
    private String descProb;
    
    @Column(name="AzioniContenimento")
    private String azioniContenimento;
    
    @Column(name="Gravità")
    private String gravita;
    
    @Column(name="DataApertura")
    private String dataA;
    
    @Column(name="DataChiusura")
    private String dataC;
    
    @Column(name="Costo")
    private String costo;
    
    @Column(name="CauseIdentificate")
    private String cause;
    
    @Column(name="AzioniCorrettive")
    private String azioniC;
    
    @Column(name="Prevenzione")
    private String prevenzione;
    
    @Column(name="RevisioneFinale")
    private String revisione;
    
    @Column(name="InterneClienteFornitore")
    private String icf;
    
    @ManyToOne
    @JoinColumn(name="ApertaDa")
    private Dipendente apertaDa;
    
    @ManyToOne
    @JoinColumn(name="Reparto")
    private Reparto reparto;
    
    @ManyToOne
    @JoinColumn(name="Fornitore")
    private Fornitore fornitore;
    
    @ManyToOne
    @JoinColumn(name="Cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy="nc")
    private Set<Elaborazione> elaborazioni = new HashSet(0);

    @ManyToMany(mappedBy="pezziNC")
     private Set<Pezzo> pezzi = new HashSet(0);
    
    @ManyToMany(mappedBy="tipiNC")
     private Set<Pezzo> tipi = new HashSet(0);
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="TEAMNC", joinColumns = { 
        @JoinColumn(name="Dipendente", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="NC", nullable=false, updatable=false) })
    private Set<NC> teamNC = new HashSet(0);
    
    public NC() {
    }

    public NC(int id, String stato, String descProb, String azioniContenimento, String gravita, String dataA, String dataC, String costo, String cause, String azioniC, String prevenzione, String revisione, String icf, Dipendente apertaDa, Reparto reparto, Fornitore fornitore, Cliente cliente) {
        this.id = id;
        this.stato = stato;
        this.descProb = descProb;
        this.azioniContenimento = azioniContenimento;
        this.gravita = gravita;
        this.dataA = dataA;
        this.dataC = dataC;
        this.costo = costo;
        this.cause = cause;
        this.azioniC = azioniC;
        this.prevenzione = prevenzione;
        this.revisione = revisione;
        this.icf = icf;
        this.apertaDa = apertaDa;
        this.reparto = reparto;
        this.fornitore = fornitore;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getGravita() {
        return gravita;
    }

    public void setGravita(String gravita) {
        this.gravita = gravita;
    }

    public String getDataA() {
        return dataA;
    }

    public void setDataA(String dataA) {
        this.dataA = dataA;
    }

    public String getDataC() {
        return dataC;
    }

    public void setDataC(String dataC) {
        this.dataC = dataC;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getPrevenzione() {
        return prevenzione;
    }

    public void setPrevenzione(String prevenzione) {
        this.prevenzione = prevenzione;
    }

    public String getRevisione() {
        return revisione;
    }

    public void setRevisione(String revisione) {
        this.revisione = revisione;
    }

    public String getIcf() {
        return icf;
    }

    public void setIcf(String icf) {
        this.icf = icf;
    }

    public void setDescProb(String descProb) {
        this.descProb = descProb;
    }

    public void setAzioniContenimento(String azioniContenimento) {
        this.azioniContenimento = azioniContenimento;
    }

    public void setAzioniC(String azioniC) {
        this.azioniC = azioniC;
    }

    public void setApertaDa(Dipendente apertaDa) {
        this.apertaDa = apertaDa;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setElaborazioni(Set<Elaborazione> elaborazioni) {
        this.elaborazioni = elaborazioni;
    }

    public void setPezzi(Set<Pezzo> pezzi) {
        this.pezzi = pezzi;
    }

    public void setTipi(Set<Pezzo> tipi) {
        this.tipi = tipi;
    }

    public void setTeamNC(Set<NC> teamNC) {
        this.teamNC = teamNC;
    }

    public String getDescProb() {
        return descProb;
    }

    public String getAzioniContenimento() {
        return azioniContenimento;
    }

    public String getAzioniC() {
        return azioniC;
    }

    public Dipendente getApertaDa() {
        return apertaDa;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Set<Elaborazione> getElaborazioni() {
        return elaborazioni;
    }

    public Set<Pezzo> getPezzi() {
        return pezzi;
    }

    public Set<Pezzo> getTipi() {
        return tipi;
    }

    public Set<NC> getTeamNC() {
        return teamNC;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        final NC other = (NC) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NC{" + "id=" + id + ", stato=" + stato + ", descProb=" + descProb + ", azioniContenimento=" + azioniContenimento + ", gravita=" + gravita + ", dataA=" + dataA + ", dataC=" + dataC + ", costo=" + costo + ", cause=" + cause + ", azioniC=" + azioniC + ", prevenzione=" + prevenzione + ", revisione=" + revisione + ", icf=" + icf + ", apertaDa=" + apertaDa + ", reparto=" + reparto + ", fornitore=" + fornitore + ", cliente=" + cliente + ", elaborazioni=" + elaborazioni + ", pezzi=" + pezzi + ", tipi=" + tipi + ", teamNC=" + teamNC + '}';
    }
 
}//NC