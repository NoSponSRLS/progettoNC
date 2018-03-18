package progettoNC.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.DipendenteDao;
import progettoNC.model.Dipendente;

@Service("dipendenteService")
@Transactional
public class DipendenteServiceImplementation implements DipendenteService, UserDetailsService {

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

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String matr) throws UsernameNotFoundException {
        Dipendente dip = dao.findDipendenteById(matr);
        List<GrantedAuthority> authorities = buildUserAuthority(dip.getRuolo());
        return buildUserForAuthentication(dip, authorities);
    }

    private User buildUserForAuthentication(Dipendente dip, List<GrantedAuthority> authorities) {
        return new User(dip.getMatricola(), dip.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(String ruolo) {
        ArrayList<GrantedAuthority> result = new ArrayList<>();
        result.add(new SimpleGrantedAuthority(ruolo));
        return result;
    }
    
}