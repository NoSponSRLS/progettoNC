package progettoNC.service;

import java.util.List;
import progettoNC.model.Fornitore;


public interface FornitoreService {
    Fornitore findFornitoreById(String piva);
    void saveFornitore(Fornitore forn);
    void updateFornitore(Fornitore forn);
    void deleteFornitore(String piva);
    List<Fornitore> findAllFornitori(); 
}
