package progettoNC.dao;

import java.util.List;
import progettoNC.model.Dipendente;

public interface DipendenteDao {
    Dipendente findDipendenteById(String matr);
    void saveDipendente(Dipendente dip);
    void deleteDipendente(String matr);
    List<Dipendente> findAllDipendenti();
}