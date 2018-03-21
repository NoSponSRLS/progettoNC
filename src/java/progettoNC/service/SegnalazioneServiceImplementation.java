package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import progettoNC.dao.SegnalazioneDao;
import progettoNC.model.Segnalazione;

public class SegnalazioneServiceImplementation implements SegnalazioneService{
   
    @Autowired
    private SegnalazioneDao dao;

    @Override
    public Segnalazione findSegnalazioneById(int id) {
        return dao.findSegnalazioneById(id);
    }

    @Override
    public void saveSegnalazione(Segnalazione segn) {
        dao.saveTipo(segn);
    }

    @Override
    public void updateSegnalazione(Segnalazione segn) {
        Segnalazione entity = dao.findSegnalazioneById(segn.getIDsegnalazione());
        if (entity != null) {
            entity.setIDsegnalazione(segn.getIDsegnalazione());
            entity.setDescrizione(segn.getDescrizione());
            entity.setDipendente(segn.getDipendente());
            entity.setData(segn.getData());
        }
    }

    @Override
    public void deleteSegnalazione(int id) {
        dao.deleteSegnalazione(id);
    }

    @Override
    public List<Segnalazione> findAllSegnalazioni() {
        return dao.findAllSegnalazioni();
    } 
}
