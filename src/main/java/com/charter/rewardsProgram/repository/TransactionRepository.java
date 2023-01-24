package com.charter.rewardsProgram.repository;

import com.charter.rewardsProgram.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;



@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {
    
    public List<Transaction> findAllByCustomerId(Long customerId);

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,Timestamp to);
}
