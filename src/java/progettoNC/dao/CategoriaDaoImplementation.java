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
import progettoNC.model.Categoria;
import progettoNC.model.Dipendente;

/**
 *
 * @author FSEVERI\santon3575
 */
public class CategoriaDaoImplementation implements CategoriaDao {

 
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Categoria findCategoriaById(int id) {
            return (Categoria) getSession().get(Categoria.class, id);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        getSession().persist(categoria);
    }

    @Override
    public void deleteCategoria(int id) {
        Categoria e = (Categoria) getSession().load(Categoria.class, id);
        if (e != null) {
            getSession().delete(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Categoria> findAllCategorie() {
        Criteria criteria = getSession().createCriteria(Categoria.class);
        return (List<Categoria>) criteria.list();
    }
}
