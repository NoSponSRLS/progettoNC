package progettoNC.service;

import java.util.List;
import progettoNC.model.Reparto;

public interface RepartoService {
    Reparto findRepartoById(int id);
    void saveReparto(Reparto rep);
    void updateReparto(Reparto rep);
    void deleteReparto(int id);
    List<Reparto> findAllReparti();
}