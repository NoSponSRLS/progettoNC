package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Dipendente;
import progettoNC.model.Segnalazione;

@Repository("segnalazioneDao")
public class SegnalazioneDaoImplementation implements SegnalazioneDao{
 
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Segnalazione findSegnalazioneById(int id) {
            return (Segnalazione) getSession().get(Segnalazione.class, id);
    }

    @Override
    public void saveSegnalazione(Segnalazione segnalazione) {
        getSession().persist(segnalazione);
    }

    @Override
    public void deleteSegnalazione(int id) {
        Segnalazione e = (Segnalazione) getSession().load(Dipendente.class, id);
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