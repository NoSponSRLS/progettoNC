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
import progettoNC.model.NC;

/**
 *
 * @author FSEVERI\santon3575
 */
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
