
package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.ElaborazioneDao;
import progettoNC.model.Elaborazione;

@Service("elaborazioneService")
@Transactional
public class ElaborazioneServiceImplementation {
     @Autowired
    private ElaborazioneDao dao;

    @Override
    public Elaborazione findElaborazioneById(int id) {
        return dao.findElaborazioneById(id);
    }

    @Override
    public void saveElaborazione(Elaborazione elaborazione) {
        dao.saveElaborazione(elaborazione);
    }

    @Override
    public void updateElaborazione(Elaborazione elaborazione) {
        Elaborazione entity = dao.findElaborazioneById(elaborazione.getID());
        if (entity != null) {
            entity.setID(elaborazione.getID());
            entity.setDataFine(elaborazione.getDataFine());
            entity.setDataInizio(elaborazione.getDataInizio());
            entity.setDescrizione(elaborazione.getDescrizione());
            entity.setDipendente(elaborazione.getDipendente());
            entity.setNc(elaborazione.getNc());
        }
    }

    @Override
    public void deleteElaborazione(int id) {
        dao.deleteElaborazione(id);
    }

    @Override
    public List<Elaborazione> findAllElaborazioni() {
        return dao.findAllElaborazioni();
    }
}
