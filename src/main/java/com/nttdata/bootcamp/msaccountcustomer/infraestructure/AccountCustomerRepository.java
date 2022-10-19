package com.nttdata.bootcamp.msaccountcustomer.infraestructure;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.msaccountcustomer.model.AccountCustomer;

@Repository
public interface AccountCustomerRepository extends ReactiveMongoRepository<AccountCustomer, Long> {

}
