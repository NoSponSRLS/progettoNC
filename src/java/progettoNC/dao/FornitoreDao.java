package progettoNC.dao;

import java.util.List;
import progettoNC.model.Fornitore;

public interface FornitoreDao {
    Fornitore findFornitoreById(String piva);
    void saveFornitore(Fornitore fornitore);
    void deleteFornitore(String piva);
    List<Fornitore> findAllFornitori();
}