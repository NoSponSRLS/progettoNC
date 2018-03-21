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
import progettoNC.model.Segnalazione;

/**
 *
 * @author FSEVERI\santon3575
 */
public class SegnalazioneDaoImplementation implements SegnalazioneDao{
 @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Segnalazione findSegnalazioneById(String IDsegnalazione) {
            return (Segnalazione) getSession().get(Segnalazione.class, IDsegnalazione);
    }

    @Override
    public void saveSegnalazione(Segnalazione segnalazione) {
        getSession().persist(segnalazione);
    }

    @Override
    public void deleteSegnalazione(String IDsegnalazione) {
        Segnalazione e = (Segnalazione) getSession().load(Dipendente.class, IDsegnalazione);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Segnalazione> findAllSegnalazioni() {
        Criteria criteria = getSession().createCriteria(Dipendente.class);
        return (List<Segnalazione>) criteria.list();
    }   
}
