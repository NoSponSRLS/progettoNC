package progettoNC.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {
    
    @Id
    @Column(name = "PIVA")
    private String PIVA;
    
    @Column(name = "NomeCliente")
    private String nomeCliente;
    
    @OneToMany(mappedBy="cliente")
    private Set<NC> NC = new HashSet(0);

    public Cliente() {
        PIVA="";
        nomeCliente="";
    }

    public Cliente(String PIVA, String nomeCliente) {
        this.PIVA = PIVA;
        this.nomeCliente = nomeCliente;
    }

    public String getPIVA() {
        return PIVA;
    }

    public void setPIVA(String PIVA) {
        this.PIVA = PIVA;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.PIVA);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.PIVA, other.PIVA)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "PIVA=" + PIVA + ", nomeCliente=" + nomeCliente + '}';
    }
      
}
