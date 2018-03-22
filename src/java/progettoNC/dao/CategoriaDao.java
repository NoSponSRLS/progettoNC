package progettoNC.dao;

import java.util.List;
import progettoNC.model.Categoria;

public interface CategoriaDao {
    Categoria findCategoriaById(int id);
    void saveCategoria(Categoria categoria);
    void deleteCategoria(int id);
    List<Categoria> findAllCategorie();
}