package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.DipendenteDao;
import progettoNC.model.Dipendente;

@Service("dipendenteService")
@Transactional
public class DipendenteServiceImplementation implements DipendenteService {

    @Autowired
    private DipendenteDao dao;

    @Override
    public Dipendente findDipendenteById(String matr) {
        return dao.findDipendenteById(matr);
    }

    @Override
    public void saveDipendente(Dipendente dip) {
        dao.saveDipendente(dip);
    }

    @Override
    public void updateDipendente(Dipendente dip) {
        Dipendente entity = dao.findDipendenteById(dip.getMatricola());
        if (entity != null) {
            entity.setMatricola(dip.getMatricola());
            entity.setNome(dip.getNome());
            entity.setCognome(dip.getCognome());
            entity.setPassword(dip.getPassword());
            entity.setRuolo(dip.getRuolo());
            entity.setReparto(dip.getReparto());
            entity.setApertaDa(dip.getApertaDa());
            entity.setSegnalazioni(dip.getSegnalazioni());
            entity.setTeams(dip.getTeams());
        }
    }

    @Override
    public void deleteDipendente(String matr) {
        dao.deleteDipendente(matr);
    }

    @Override
    public List<Dipendente> findAllDipendenti() {
        return dao.findAllDipendenti();
    }
    
}