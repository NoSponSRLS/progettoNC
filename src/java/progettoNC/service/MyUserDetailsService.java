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

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private DipendenteDao dao;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String matr) throws UsernameNotFoundException {
        Dipendente dip = dao.findDipendenteById(matr);
        List<GrantedAuthority> authorities = buildUserAuthority(dip.getRuolo().toString());
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
