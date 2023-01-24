package com.charter.rewardsProgram.repository;



import com.charter.rewardsProgram.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByCustomerId(Long customerId);
    List<Customer> findAll();

}
