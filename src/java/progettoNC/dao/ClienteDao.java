package progettoNC.dao;
import java.util.List;
import progettoNC.model.Cliente;

public interface ClienteDao {
    Cliente findClienteById(String piva);
    void saveCliente(Cliente cliente);
    void deleteCliente(String piva);
    List<Cliente> findAllClienti();
}