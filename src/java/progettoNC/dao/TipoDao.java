package progettoNC.dao;

import java.util.List;
import progettoNC.model.Tipo;

public interface TipoDao {
    Tipo findTipoById(String nome);
    void saveTipo(Tipo tipo);
    void deleteTipo(String nome);
    List<Tipo> findAllTipi();  
}