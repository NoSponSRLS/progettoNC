package progettoNC.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.CategoriaDao;
import progettoNC.model.Categoria;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImplementation {
    @Autowired
    private CategoriaDao dao;

    @Override
    public Categoria findCategoriaById(int id) {
        return dao.findCategoriaById(id);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
        dao.saveCategoria(categoria);
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        Categoria entity = dao.findCategoriaById(categoria.getId());
        if (entity != null) {
            entity.setId(categoria.getId());
            entity.setPezzi(categoria.getPezzi());
            entity.setDescrizione(categoria.getDescrizione());
        }
    }

    @Override
    public void deleteCategoria(int id) {
        dao.deleteCategoria(id);
    }

    @Override
    public List<Categoria> findAllCategorie() {
        return dao.findAllCategorie();
    }
}
