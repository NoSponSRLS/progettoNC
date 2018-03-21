package progettoNC.service;

import java.util.List;
import progettoNC.model.Categoria;

public interface CategoriaService {
    Categoria findCategoriaById(int id);
    void saveCategoria(Categoria cat);
    void updateCategoria(Categoria cat);
    void deleteCategoria(int id);
    List<Categoria> findAllCategorie(); 
}
