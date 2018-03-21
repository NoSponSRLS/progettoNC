package progettoNC.dao;

import java.util.List;
import progettoNC.model.Pezzo;


public interface PezzoDao {
    Pezzo findPezzoById(int id);
    void savePezzo(Pezzo pezzo);
    void deletePezzo(int id);
    List<Pezzo> findAllPezzi();  
}
