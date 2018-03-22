package progettoNC.dao;

import java.util.List;
import progettoNC.model.Segnalazione;

public interface SegnalazioneDao {
    Segnalazione findSegnalazioneById(int id);
    void saveSegnalazione(Segnalazione segnalazione);
    void deleteSegnalazione(int id);
    List<Segnalazione> findAllSegnalazioni();  
}