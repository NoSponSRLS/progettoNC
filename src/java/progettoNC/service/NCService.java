package progettoNC.service;

import java.util.List;
import progettoNC.model.NC;

public interface NCService {
    NC findNCById(int id);
    void saveNC(NC nc);
    void updateNC(NC nc);
    void deleteNC(int id);
    List<NC> findAllNC(); 
}