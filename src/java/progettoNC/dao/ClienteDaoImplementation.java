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
import progettoNC.model.Cliente;
import progettoNC.model.Dipendente;

/**
 *
 * @author FSEVERI\santon3575
 */
public class ClienteDaoImplementation implements ClienteDao{
     @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Cliente findClienteById(String piva) {
            return (Cliente) getSession().get(Cliente.class, piva);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        getSession().persist(cliente);
    }

    @Override
    public void deleteCliente(String piva) {
        Cliente e = (Cliente) getSession().load(Cliente.class, piva);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAllClienti() {
        Criteria criteria = getSession().createCriteria(Cliente.class);
        return (List<Cliente>) criteria.list();
    }
}
