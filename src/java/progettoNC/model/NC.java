/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String descprob;
    
    @Column(name="AzioniContenimento")
    private String azionicontenimento;
    
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
    private String azionic;
    
    @Column(name="Prevenzione")
    private String prevenzione;
    
    @Column(name="RevisioneFinale")
    private String revisione;
    
    @Column(name="InterneClienteFornitore")
    private String icf;
    
    @ManyToOne
    @JoinColumn(name="ApertaDa")
    private NC apertaDa;
    
    @ManyToOne
    @JoinColumn(name="Reparto")
    private NC reparto;
    
    @ManyToOne
    @JoinColumn(name="Fornitore")
    private NC fornitore;
    
    @ManyToOne
    @JoinColumn(name="Cliente")
    private NC cliente;
    
    @OneToMany(mappedBy="nc")
    private Set<Elaborazione> elaborazioni = new HashSet(0);

    public NC() {
    }

    public NC(int id, String stato, String descprob, String azionicontenimento, String gravita, String dataA, String dataC, String apertada, String reparto, String costo, String cause, String azionic, String prevenzione, String revisione, String icf, String fornitore, String cliente) {
        this.id = id;
        this.stato = stato;
        this.descprob = descprob;
        this.azionicontenimento = azionicontenimento;
        this.gravita = gravita;
        this.dataA = dataA;
        this.dataC = dataC;
        this.costo = costo;
        this.cause = cause;
        this.azionic = azionic;
        this.prevenzione = prevenzione;
        this.revisione = revisione;
        this.icf = icf;
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

    public String getDescprob() {
        return descprob;
    }

    public void setDescprob(String descprob) {
        this.descprob = descprob;
    }

    public String getAzionicontenimento() {
        return azionicontenimento;
    }

    public void setAzionicontenimento(String azionicontenimento) {
        this.azionicontenimento = azionicontenimento;
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

    public String getAzionic() {
        return azionic;
    }

    public void setAzionic(String azionic) {
        this.azionic = azionic;
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
        return "NC{" + "id=" + id + ", stato=" + stato + ", descprob=" + descprob + ", azionicontenimento=" + azionicontenimento + ", gravita=" + gravita + ", dataA=" + dataA + ", dataC=" + dataC + ", reparto=" + reparto + ", costo=" + costo + ", cause=" + cause + ", azionic=" + azionic + ", prevenzione=" + prevenzione + ", revisione=" + revisione + ", icf=" + icf + ", fornitore=" + fornitore + ", cliente=" + cliente + '}';
    }
    
}
