/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.FornitoreDao;
import progettoNC.model.Fornitore;

@Service("fornitoreService")
@Transactional
public class FornitoreServiceImplementation {
     @Autowired
    private FornitoreDao dao;

    @Override
    public Fornitore findFornitoreById(String piva) {
        return dao.findFornitoreById(piva);
    }

    @Override
    public void saveFornitore(Fornitore fornitore) {
        dao.saveFornitore(fornitore);
    }

    @Override
    public void updateFornitore(Fornitore fornitore) {
        Fornitore entity = dao.findFornitoreById(fornitore.getPIVA());
        if (entity != null) {
            entity.setPIVA(fornitore.getPIVA());
            entity.setNC(fornitore.getNC());
            entity.setNomeFornitore(fornitore.getNomeFornitore());
        }
    }

    @Override
    public void deleteFornitore(String piva) {
        dao.deleteFornitore(piva);
    }

    @Override
    public List<Fornitore> findAllFornitori() {
        return dao.findAllFornitori();
    }
}
