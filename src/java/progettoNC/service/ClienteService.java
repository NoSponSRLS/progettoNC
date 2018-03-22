package progettoNC.service;

import java.util.List;
import progettoNC.model.Cliente;

public interface ClienteService {
    Cliente findClienteById(String piva);
    void saveCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void deleteCliente(String piva);
    List<Cliente> findAllClienti(); 
}