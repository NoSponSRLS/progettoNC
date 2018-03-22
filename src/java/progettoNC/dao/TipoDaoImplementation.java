package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Tipo;

@Repository("tipoDao")
public class TipoDaoImplementation implements TipoDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Tipo findTipoById(String nome) {
            return (Tipo) getSession().get(Tipo.class, nome);
    }

    @Override
    public void saveTipo(Tipo tipo) {
        getSession().persist(tipo);
    }

    @Override
    public void deleteTipo(String nome) {
       Tipo e = (Tipo) getSession().load(Tipo.class, nome);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tipo> findAllTipi() {
        Criteria criteria = getSession().createCriteria(Tipo.class);
        return (List<Tipo>) criteria.list();
    }
    
}