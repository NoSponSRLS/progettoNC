package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.NCDao;
import progettoNC.model.NC;

@Service("ncService")
@Transactional
public class NCServiceImplementation implements NCService{
     
    @Autowired
    private NCDao dao;

    @Override
    public NC findNCById(int id) {
        return dao.findNCById(id);
    }

    @Override
    public void saveNC(NC nc) {
        dao.saveNC(nc);
    }

    @Override
    public void updateNC(NC nc) {
        NC entity = dao.findNCById(nc.getId());
        if (entity != null) {
            entity.setId(nc.getId());
            entity.setAzioniC(nc.getAzioniC());
            entity.setApertaDa(nc.getApertaDa());
            entity.setAzioniContenimento(nc.getAzioniContenimento());
            entity.setCause(nc.getCause());
            entity.setCliente(nc.getCliente());
            entity.setCosto(nc.getCosto());
            entity.setDataA(nc.getDataA());
            entity.setDataC(nc.getDataC());
            entity.setDescProb(nc.getDescProb());
            entity.setElaborazioni(nc.getElaborazioni());
            entity.setFornitore(nc.getFornitore());
            entity.setGravita(nc.getGravita());
            entity.setIcf(nc.getIcf());
            entity.setPezzi(nc.getPezzi());
            entity.setPrevenzione(nc.getPrevenzione());
            entity.setReparto(nc.getReparto());
            entity.setRevisione(nc.getRevisione());
            entity.setTeamNC(nc.getTeamNC());
            entity.setTipi(nc.getTipi());
        }
    }

    @Override
    public void deleteNC(int id) {
        dao.deleteNC(id);
    }

    @Override
    public List<NC> findAllNC() {
        return dao.findAllNC();
    }
    
}