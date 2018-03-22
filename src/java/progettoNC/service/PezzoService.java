package progettoNC.service;

import java.util.List;
import progettoNC.model.Pezzo;

public interface PezzoService {
    Pezzo findPezzoById(int id);
    void savePezzo(Pezzo pezzo);
    void updatePezzo(Pezzo pezzo);
    void deletePezzo(int id);
    List<Pezzo> findAllPezzi();
}