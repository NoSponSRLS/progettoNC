package progettoNC.dao;

import java.util.List;
import progettoNC.model.Segnalazione;

public interface SegnalazioneDao {
       Segnalazione findSegnalazioneById(String IDsegnalazione);
    void saveSegnalazione(Segnalazione segnalazione);
    void deleteSegnalazione(String IDsegnalazione);
    List<Segnalazione> findAllSegnalazioni();  
}
