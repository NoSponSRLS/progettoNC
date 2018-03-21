package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.model.Tipo;

@Service("tipoService")
@Transactional
public class TipoServiceImplementation {
    
    @Autowired
    private TipoDao dao;

    @Override
    public Tipo findTipoById(String nome) {
        return dao.findDipendenteById(nome);
    }

    @Override
    public void saveTipo(Tipo tipo) {
        dao.saveTipo(tipo);
    }

    @Override
    public void updateTipo(Tipo tipo) {
        Tipo entity = dao.findTipoById(tipo.getNome());
        if (entity != null) {
            entity.setNome(tipo.getNome());
            entity.setDescrizione(tipo.getDescrizione());
            entity.setTipiNC(tipo.getTipiNC());
        }
    }

    @Override
    public void deleteTipo(String nome) {
        dao.deleteTipo(nome);
    }

    @Override
    public List<Tipo> findAllTipi() {
        return dao.findAllTipi();
    }
}
