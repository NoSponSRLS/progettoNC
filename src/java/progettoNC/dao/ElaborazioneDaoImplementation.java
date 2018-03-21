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
import progettoNC.model.Elaborazione;

/**
 *
 * @author FSEVERI\santon3575
 */
public class ElaborazioneDaoImplementation implements ElaborazioneDao {
  
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Elaborazione findElaborazioneById(int id) {
            return (Elaborazione) getSession().get(Elaborazione.class, id);
    }

    @Override
    public void saveElaborazione(Elaborazione elaborazione) {
        getSession().persist(elaborazione);
    }

    @Override
    public void deleteElaborazione(int id) {
        Elaborazione e = (Elaborazione) getSession().load(Elaborazione.class, id);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Elaborazione> findAllElaborazioni() {
        Criteria criteria = getSession().createCriteria(Elaborazione.class);
        return (List<Elaborazione>) criteria.list();
    }
}
