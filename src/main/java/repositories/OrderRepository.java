package repositories;

import models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "store", collectionResourceRel = "store")
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
