package progettoNC.service;

import java.util.List;
import progettoNC.model.Dipendente;

public interface DipendenteService {
    Dipendente findDipendenteById(String matr);
    void saveDipendente(Dipendente dip);
    void updateDipendente(Dipendente dip);
    void deleteDipendente(String matr);
    List<Dipendente> findAllDipendenti(); 
}
