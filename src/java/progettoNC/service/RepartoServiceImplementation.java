package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import progettoNC.model.Reparto;

public class RepartoServiceImplementation {
       
    @Autowired
    private RepartoDao dao;

    @Override
    public Reparto findRepartoById(int id) {
        return dao.findRepartoById(id);
    }

    @Override
    public void saveReparto(Reparto rep) {
        dao.saveTipo(rep);
    }

    @Override
    public void updateReparto(Reparto rep) {
        Reparto entity = dao.findTipoById(rep.getId());
        if (entity != null) {
            entity.setId(rep.getId());
            entity.setNome(rep.getNome());
            entity.setDipendenti(rep.getDipendenti());
            entity.setNC(rep.getNC());
        }
    }

    @Override
    public void deleteReparto(int id) {
        dao.deleteReparto(id);
    }

    @Override
    public List<Reparto> findAllReparti() {
        return dao.findAllReparti();
    } 
}
