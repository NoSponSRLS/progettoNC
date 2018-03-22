package progettoNC.service;

import java.util.List;
import progettoNC.model.Elaborazione;

public interface ElaborazioneService {
    Elaborazione findElaborazioneById(int id);
    void saveElaborazione(Elaborazione elaborazione);
    void updateElaborazione(Elaborazione elaborazione);
    void deleteElaborazione(int id);
    List<Elaborazione> findAllElaborazioni(); 
}