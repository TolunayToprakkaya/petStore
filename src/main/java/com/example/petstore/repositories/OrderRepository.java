package com.example.petstore.repositories;

import com.example.petstore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order", collectionResourceRel = "order")
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
