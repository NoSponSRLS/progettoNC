package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Dipendente;
import progettoNC.model.Reparto;

@Repository("repartoDao")
public class RepatoDaoImplementation implements RepartoDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Reparto findRepartoById(int id) {
            return (Reparto) getSession().get(Dipendente.class, id);
    }

    @Override
    public void saveReparto(Reparto reparto) {
        getSession().persist(reparto);
    }

    @Override
    public void deleteReparto(int id) {
        Reparto e = (Reparto) getSession().load(Reparto.class, id);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reparto> findAllReparti() {
        Criteria criteria = getSession().createCriteria(Reparto.class);
        return (List<Reparto>) criteria.list();
    }

}