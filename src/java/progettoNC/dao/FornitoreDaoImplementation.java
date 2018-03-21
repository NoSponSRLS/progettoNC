/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import progettoNC.model.Dipendente;
import progettoNC.model.Fornitore;

/**
 *
 * @author FSEVERI\santon3575
 */
public class FornitoreDaoImplementation implements FornitoreDao{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Fornitore findFornitoreById(String piva) {
            return (Fornitore) getSession().get(Fornitore.class, piva);
    }

    @Override
    public void saveFornitore(Fornitore fornitore) {
        getSession().persist(fornitore);
    }

    @Override
    public void deleteFornitore(String piva) {
        Fornitore e = (Fornitore) getSession().load(Fornitore.class, piva);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Fornitore> findAllFornitori() {
        Criteria criteria = getSession().createCriteria(Fornitore.class);
        return (List<Fornitore>) criteria.list();
    }
}
