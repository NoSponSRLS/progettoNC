package progettoNC.service;

import java.util.List;
import progettoNC.model.Segnalazione;

public interface SegnalazioneService {
    Segnalazione findSegnalazioneById(int id);
    void saveSegnalazione(Segnalazione segn);
    void updateSegnalazione(Segnalazione segn);
    void deleteSegnalazione(int id);
    List<Segnalazione> findAllSegnalazioni();
}