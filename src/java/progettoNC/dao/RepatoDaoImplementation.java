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
import progettoNC.model.Reparto;

/**
 *
 * @author FSEVERI\santon3575
 */
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
