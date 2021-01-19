package restfulwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restfulwebservice.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
