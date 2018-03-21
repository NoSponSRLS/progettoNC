package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import progettoNC.dao.PezzoDao;
import progettoNC.model.Pezzo;

public class PezzoServiceImplementation implements PezzoService{
    
    @Autowired
    private PezzoDao dao;

    @Override
    public Pezzo findPezzoById(int id) {
        return dao.findPezzoById(id);
    }

    @Override
    public void savePezzo(Pezzo pezzo) {
        dao.savePezzo(pezzo);
    }

    @Override
    public void updatePezzo(Pezzo pezzo) {
        Pezzo entity = dao.findPezzoById(pezzo.getId());
        if (entity != null) {
            entity.setId(pezzo.getId());
            entity.setCategoria(pezzo.getCategoria());
            entity.setPezziNC(pezzo.getPezziNC());
        }
    }

    @Override
    public void deletePezzo(int id) {
        dao.deletePezzo(id);
    }

    @Override
    public List<Pezzo> findAllPezzi() {
        return dao.findAllPezzi();
    } 
    
}
