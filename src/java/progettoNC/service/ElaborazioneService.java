package progettoNC.service;

import java.util.List;
import progettoNC.model.Elaborazione;


public interface ElaborazioneService {
    Elaborazione findElaborazioneById(int id);
    void saveElaborazione(Elaborazione ela);
    void updateElaborazione(Elaborazione ela);
    void deleteElaborazione(int id);
    List<Elaborazione> findAllElaborazioni(); 
}
