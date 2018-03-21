package progettoNC.service;

import java.util.List;
import progettoNC.model.Tipo;


public interface TipoService {
    Tipo findTipoById(int id);
    void saveTipo(Tipo tipo);
    void updateTipo(Tipo tipo);
    void deleteTipo(int id);
    List<Tipo> findAllTipi(); 
}
