package com.ord.catalogservice.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository /// here is the trick
public interface CustomerRepository extends CrudRepository<Customer, Integer> {}

