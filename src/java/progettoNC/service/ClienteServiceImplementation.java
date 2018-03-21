
package progettoNC.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettoNC.dao.ClienteDao;
import progettoNC.model.Cliente;

@Service("clineteService")
@Transactional
public class ClienteServiceImplementation implements ClienteService {
    @Autowired
    private ClienteDao dao;

    @Override
    public Cliente findClienteById(String piva) {
        return dao.findClienteById(piva);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        dao.saveCliente(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        Cliente entity = dao.findClienteById(cliente.getPIVA());
        if (entity != null) {
            entity.setPIVA(cliente.getPIVA());
            entity.setNC(cliente.getNC());
            entity.setNomeCliente(cliente.getNomeCliente());
        }
    }

    @Override
    public void deleteCliente(String piva) {
        dao.deleteCliente(piva);
    }

    @Override
    public List<Cliente> findAllClienti() {
        return dao.findAllClienti();
    }
}
