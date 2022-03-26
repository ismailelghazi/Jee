package cigma.pfe.repositories;
import cigma.pfe.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;//crud+pag+jpa
import org.springframework.data.repository.PagingAndSortingRepository;//crud+pag
import org.springframework.data.repository.CrudRepository;//crud
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    List <Client> findByName(String name);
}