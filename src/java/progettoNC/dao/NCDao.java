package progettoNC.dao;

import java.util.List;
import progettoNC.model.NC;

public interface NCDao {
    NC findNCById(int id);
    void saveNC(NC nc);
    void deleteNC(int id);
    List<NC> findAllNC();  
}