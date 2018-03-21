package progettoNC.service;

import java.util.List;
import progettoNC.model.Pezzo;


public interface PezzoService {
    Pezzo findPezzoById(int id);
    void savePezzo(Pezzo pez);
    void updatePezzo(Pezzo pez);
    void deletePezzo(int id);
    List<Pezzo> findAllPezzi();
}
