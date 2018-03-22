package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Pezzo;

@Repository("pezzoDao")
public class PezzoDaoimplementation implements PezzoDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Pezzo findPezzoById(int id) {
            return (Pezzo) getSession().get(Pezzo.class, id);
    }

    @Override
    public void savePezzo(Pezzo pezzo) {
        getSession().persist(pezzo);
    }

    @Override
    public void deletePezzo(int id) {
        Pezzo e = (Pezzo) getSession().load(Pezzo.class, id);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pezzo> findAllPezzi() {
        Criteria criteria = getSession().createCriteria(Pezzo.class);
        return (List<Pezzo>) criteria.list();
    }
    
}