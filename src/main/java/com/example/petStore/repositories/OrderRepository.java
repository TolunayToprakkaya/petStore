package com.example.petStore.repositories;

import com.example.petStore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders", exported = false)
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findOneById(String id);
    void delete(String id);

}
