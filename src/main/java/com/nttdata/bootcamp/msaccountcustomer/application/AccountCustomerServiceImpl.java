package com.nttdata.bootcamp.msaccountcustomer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.msaccountcustomer.infraestructure.AccountCustomerRepository;
import com.nttdata.bootcamp.msaccountcustomer.model.AccountCustomer;

import reactor.core.publisher.Mono;

@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {
	
	@Autowired
	AccountCustomerRepository accountCustomerRepository; 

	@Override
	public Mono<AccountCustomer> crearCuenta(Mono<AccountCustomer> countCustomer) {
		return countCustomer.flatMap(accountCustomerRepository::insert);
	}

}
