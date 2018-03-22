package progettoNC.dao;
import java.util.List;
import progettoNC.model.Elaborazione;

public interface ElaborazioneDao {
    Elaborazione findElaborazioneById(int id);
    void saveElaborazione(Elaborazione elaborazione);
    void deleteElaborazione(int id);
    List<Elaborazione> findAllElaborazioni();
}