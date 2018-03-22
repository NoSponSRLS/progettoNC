package progettoNC.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import progettoNC.model.Cliente;

@Repository("clienteDao")
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