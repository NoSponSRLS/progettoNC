
package progettoNC.dao;

import java.util.List;
import progettoNC.model.Reparto;


public interface RepartoDao {
     Reparto findNCById(int id);
    void saveReparto(Reparto reparto);
    void deleteReparto(int id);
    List<Reparto> findAllReparto();  
}
