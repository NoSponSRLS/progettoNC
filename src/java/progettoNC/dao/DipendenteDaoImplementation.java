package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Dipendente;

@Repository("dipendenteDao")
public class DipendenteDaoImplementation implements DipendenteDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Dipendente findDipendenteById(String matr) {
            return (Dipendente) getSession().get(Dipendente.class, matr);
    }

    @Override
    public void saveDipendente(Dipendente dip) {
        getSession().persist(dip);
    }

    @Override
    public void deleteDipendente(String matr) {
        Dipendente e = (Dipendente) getSession().load(Dipendente.class, matr);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dipendente> findAllDipendenti() {
        Criteria criteria = getSession().createCriteria(Dipendente.class);
        return (List<Dipendente>) criteria.list();
    }
    
}