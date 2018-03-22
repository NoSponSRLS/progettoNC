package progettoNC.service;

import java.util.List;
import progettoNC.model.Tipo;

public interface TipoService {
    Tipo findTipoById(String nome);
    void saveTipo(Tipo tipo);
    void updateTipo(Tipo tipo);
    void deleteTipo(String nome);
    List<Tipo> findAllTipi(); 
}