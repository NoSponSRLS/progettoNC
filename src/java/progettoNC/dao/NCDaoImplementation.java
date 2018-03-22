package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.NC;

@Repository("ncDao")
public class NCDaoImplementation implements NCDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public NC findNCById(int id) {
            return (NC) getSession().get(NC.class, id);
    }

    @Override
    public void saveNC(NC nc) {
        getSession().persist(nc);
    }

    @Override
    public void deleteNC(int id) {
        NC e = (NC) getSession().load(NC.class, id);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NC> findAllNC() {
        Criteria criteria = getSession().createCriteria(NC.class);
        return (List<NC>) criteria.list();
    }
    
}