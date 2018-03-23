package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "user", collectionResourceRel = "user")
public interface UserRepository extends JpaRepository<User, Integer> {
}
